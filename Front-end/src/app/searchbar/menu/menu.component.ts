import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { timer } from 'rxjs';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  textArea = '';
  errorTypes = 0;
  showSuccess = 0;

  comments: any = [];
  storedIPs: any  = [];

  show = false;
  showError = false
  uppestComment: any;

  timer: any;

  constructor(private http: HttpClient, private appComponent: AppComponent) { }

  ngOnInit(): void
  {
    this.timer = timer(0, 1000).subscribe(() =>
    {
      if(sessionStorage.getItem('SSID') === "admin" && sessionStorage.getItem('hasLoaded') === "true")
      {
        this.show = this.appComponent.isAdmin;
        this.http.get<any[]>(this.appComponent.apiUrl + 'Comments',
        {
          observe: 'body',
          headers: new HttpHeaders({
            Authorization: 'Bearer ' + sessionStorage.getItem('token')
          })}
        ).subscribe(data => {
          this.comments = data;
  
          this.http.get<any[]>(this.appComponent.apiUrl + 'VisitIPs',
          {
            headers: new HttpHeaders({
              Authorization: 'Bearer ' + sessionStorage.getItem('token')
            })
          }).subscribe(ips => {
            this.storedIPs = ips;
            for(let i = 0; i < this.storedIPs.length; i++)
            {
              let date = new Date(this.storedIPs[i].fecha_visita);
              this.storedIPs[i].fecha_visita = date.toLocaleString('en-US', {
                month: 'short',
                day: 'numeric',
                year: 'numeric',
                hour: 'numeric',
                minute: 'numeric',
                second: 'numeric'
              });
  
            }
          });
  
          for (let i = 0; i < this.comments.length; i++)
          {
            const date = new Date(this.comments[i].uploaddate);
            const now = new Date();
            const diff = now.getTime() - date.getTime();
            const days = Math.floor(diff / (1000 * 60 * 60 * 24));
            const months = Math.floor(diff / (1000 * 60 * 60 * 24 * 30));
            const years = Math.floor(diff / (1000 * 60 * 60 * 24 * 30 * 12));
            if (years > 0){
              this.comments[i].fecha_diff = years + ' years ago';
            }
            else if (months > 0){
              this.comments[i].fecha_diff = months + ' months ago';
            }
            else if (days > 0){
              this.comments[i].fecha_diff = days + ' days ago';
            }
            else{
              this.comments[i].fecha_diff = 'today';
            }
  
            if (this.comments[i].ip == '201.216.239.185' || this.comments[i].ip == '186.13.97.190')
            {
              this.comments[i].ip += ' Workplace';
            }
            else if (this.comments[i].ip == '186.13.96.12')
            {
              this.comments[i].ip += ' Home';
            }
            else
            {
              this.comments[i].ip += ' Other';
            }
          }
          this.comments.sort((a: { uploaddate: string | number | Date; }, b: { uploaddate: string | number | Date; }) => {
            return new Date(b.uploaddate).getTime() - new Date(a.uploaddate).getTime();
          });
          this.uppestComment = this.comments[0];
        });
        this.timer.unsubscribe();
      }
    });

  }

  cargarComentario(): void
  {
    if(this.textArea == '' || this.textArea == null)
    {
      this.errorTypes = 1;
      return;
    }

    this.http.get<any>(this.appComponent.apiUrl + "ClientIP", {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
          this.http.post<any>(this.appComponent.apiUrl + 'Comments', {
            comment: this.textArea,
            ip: data.ip
          }, {
            observe: 'response',
            headers: new HttpHeaders({
              'Authorization': 'Bearer ' + sessionStorage.getItem('token')
            })
          }
          ).subscribe(data => {
            if (data.status === 200)
            {
              this.errorTypes = 0;
              this.showSuccess = 1;
              this.textArea = '';
              this.comments.push(data.body);
              const date = new Date(data.body.uploaddate);
              const now = new Date();
              const diff = now.getTime() - date.getTime();
              const days = Math.floor(diff / (1000 * 60 * 60 * 24));
              const months = Math.floor(diff / (1000 * 60 * 60 * 24 * 30));
              const years = Math.floor(diff / (1000 * 60 * 60 * 24 * 30 * 12));
              if (years > 0){
                this.comments[this.comments.length - 1].fecha_diff = years + ' years ago';
              }
              else if (months > 0){
                this.comments[this.comments.length - 1].fecha_diff = months + ' months ago';
              }
              else if (days > 0){
                this.comments[this.comments.length - 1].fecha_diff = days + ' days ago';
              }
              else{
                this.comments[this.comments.length - 1].fecha_diff = 'today';
              }
              this.comments.sort((a: { uploaddate: string | number | Date; }, b: { uploaddate: string | number | Date; }) => {
                return new Date(b.uploaddate).getTime() - new Date(a.uploaddate).getTime();
              });
            }
            else
            {
              this.errorTypes = 2;
            }
          }); 
    });

   
  }

}
