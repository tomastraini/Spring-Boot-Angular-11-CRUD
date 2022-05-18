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
  loading = false;
  loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando...' : 'Loading...';
  interval = 0;
  ngOnInit(): void
  {
  }

  changeLang()
  {
    this.appComponent.changeLanguage();
  }

  loadingScreen()
  {
    this.interval = 0
    this.loading = true;
    setTimeout(() => {
      this.loadingMessage =  this.appComponent.actualLang() == 'es' ?" Cargando." : "Loading.";
    }, 1000);

    setInterval(() => {
      console.log(this.interval);
      if(this.interval < 5)
      {
        setTimeout(() => {
          this.loadingMessage =  this.appComponent.actualLang() == 'es' ? 'Cargando.' : 'Loading.';
          setTimeout(() => {
            this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando..' : 'Loading..';
            setTimeout(() => {
              this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando...' : 'Loading...';
            }, 500);
          }, 500);
        }, 500);
        this.interval += 1;
      }
      
      if(this.interval >= 4  && this.interval < 8)
      {
        setTimeout(() => {
          this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Abriendo base de datos.' : 'Opening database.';
          setTimeout(() => {
            this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Abriendo base de datos..' : 'Opening database..';
            setTimeout(() => {
              this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Abriendo base de datos...' : 'Opening database...';
            }, 500);
          }, 500);
        }, 500);
        this.interval += 1;
      }

      if(this.interval >= 8 && this.interval < 12)
      {
        setTimeout(() => {
          this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Iniciando sesión.' : 'Starting session.';
          setTimeout(() => {
            this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Iniciando sesión..' : 'Starting session..';
            setTimeout(() => {
              this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Iniciando sesión...' : 'Starting session...';
            }, 500);
          }, 500);
        }, 500);
        this.interval += 1;
      }

      if(this.interval >= 12)
      {
        setTimeout(() => {
          this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando datos.' : 'Loading data.';
          setTimeout(() => {
            this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando datos..' : 'Loading data..';
            setTimeout(() => {
              this.loadingMessage = this.appComponent.actualLang() == 'es' ? 'Cargando datos...' : 'Loading data...';
            }, 500);
          }, 500);
        }, 500);
        this.interval += 1;
      }

    }, 1500);
    
  }

  login(): void
  {
    
    this.loadingScreen();
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
                if(this.user === 'admin')
                {
                sessionStorage.setItem('y', this.password);
                }
                window.location.href = '/';
              }
              else
              {
                this.errorTypes = 1;
                this.loading = false;
              }
            },
            err =>
            {
              this.errorTypes = 1;
              this.loading = false;
            }
          );
        }
        else
        {
          this.errorTypes = 1;
          this.loading = false;
        }
      },
      err =>
      {
        this.errorTypes = 1;
        this.loading = false;
      }
    );
  }

}
