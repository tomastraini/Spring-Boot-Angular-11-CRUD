import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(public http: HttpClient, public router: Router, private appComponent: AppComponent) {  }
  user: any;
  password: any;
  errorTypes = 0;
  ngOnInit(): void
  {
  }
  login(event: any): void
  {
    this.http.post(this.appComponent.apiUrl + 'authenticate',
    {
      username: this.user,
      password: this.password
    },
    {
      observe: 'response',
      responseType: 'json',
    }).subscribe(
      res =>
      {
        if (res.status === 200 && res.body !== null)
        {
          const response = JSON.stringify(res.body);
          const json = JSON.parse(response);
          sessionStorage.setItem('token', json.token);
          this.http.get(this.appComponent.apiUrl + 'users/' + this.user,
          {
            observe: 'response',
            responseType: 'json',
            headers: new HttpHeaders({
              Authorization: 'Bearer ' + sessionStorage.getItem('token')
            })
          }).subscribe(
            res =>
            {
              if (res.status === 200 && res.body !== null)
              {
                const response = JSON.stringify(res.body);
                const json = JSON.parse(response);
                sessionStorage.setItem('x', json.id_usuario);
                sessionStorage.setItem('SSID', json.usuario);
                sessionStorage.setItem('y', json.pass);
                window.location.href = '/';
              }
              else
              {
                this.errorTypes = 1;
              }
            },
            err =>
            {
              this.errorTypes = 1;
            }
          );
        }
        else
        {
          this.errorTypes = 1;
        }
      },
      err =>
      {
        this.errorTypes = 1;
        console.log(err);
      }
    );
  }

}
