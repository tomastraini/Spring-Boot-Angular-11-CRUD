import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { EnvService } from './Services/env.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  // apiUrl = 'http://localhost:44043/api/';
  apiUrl = 'https://springbootangular11crud.herokuapp.com/api/';
  title = 'front-end';
  isAdmin = false;
  IPsWhitelist: any;
  constructor(private http: HttpClient, private env: EnvService, public translate: TranslateService) { 
        const langFullPath = env.indexPath + env.langPath + env.langDefault;
        this.translate.setDefaultLang(langFullPath);
        this.translates(langFullPath);
  }
  translates(lang: string): void {
    this.translate.use(lang);
  }
  ngOnInit(): void
  {
    sessionStorage.removeItem("hasLoaded");
    if(sessionStorage.getItem('token') != null && sessionStorage.getItem('token') != undefined)
    {
      this.http.get<any>(this.apiUrl + "ClientIP", {
        headers: new HttpHeaders({
          Authorization: 'Bearer ' + sessionStorage.getItem('token')
        })
      }).subscribe(data1 => {
        this.http.get<any>(this.apiUrl + "Whitelist",
        {
          headers: new HttpHeaders({
            Authorization: 'Bearer ' + sessionStorage.getItem('token')
          })
        }).subscribe(data => {
          this.IPsWhitelist = data;
          var dataContainsdata1;
          for(var i = 0; i < data.length; i++)
          {
            if(data[i].ip.includes(data1.ip))
            {
              dataContainsdata1 = true;
              break;
            }
          }

          if(!dataContainsdata1)
          {
            this.http.post<any>(this.apiUrl + "VisitIPs", {
              ip: data1.ip
            },
            {
              headers: new HttpHeaders({
                Authorization: 'Bearer ' + sessionStorage.getItem('token')
              })
            }).subscribe(data => {
            });
          }
        });
      });
    }

    if(sessionStorage.getItem("SSID") !== undefined && sessionStorage.getItem("SSID") !== null && sessionStorage.getItem("SSID") !== "user")
    {
      this.http.post<any>(this.apiUrl + "authenticate", {
        username: sessionStorage.getItem("SSID"),
        password: sessionStorage.getItem("y")
      },
      {
        observe: 'response',
        responseType: 'json',
      }).subscribe(
        res =>
        {
          sessionStorage.setItem("hasLoaded", "true");
          if(res.status === 200  && res.body !== null)
          {
            this.isAdmin = true;
          }
          else
          {
            sessionStorage.clear();
            window.location.href = '/login';
          }
        });
    }

  }

  changeLanguage(lang: string)
  {
    this.env.langDefault = this.env.langDefault = lang;
    sessionStorage.setItem('lang', this.env.langDefault);
    window.location.reload();
  }

  actualLang()
  {
    return this.env.langDefault;
  }
}
