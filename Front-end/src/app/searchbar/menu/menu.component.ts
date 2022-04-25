import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  textArea = '';
  errorTypes = 0;
  comments: any = [];
  show = false;

  constructor(private http: HttpClient, private appComponent: AppComponent) { }


  ngOnInit(): void
  {
    if(sessionStorage.getItem('SSID') == 'admin')
    {
      this.show = true;
      this.http.get<any[]>(this.appComponent.apiUrl + 'Comments',
      {
        observe: 'body',
        headers: new HttpHeaders({
          Authorization: 'Bearer ' + sessionStorage.getItem('token')
        })}
      ).subscribe(data => {
        this.comments = data;
        console.log(this.comments);
        
        for (let i = 0; i < this.comments.length; i++){
          
        const date = new Date(this.comments[i].fecha_carga);
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
        }
      });
    }
  }
  cargarComentario(): void
  {
    this.http.post(this.appComponent.apiUrl + 'Comments', {
      comment: this.textArea
    }, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }
    ).subscribe(data => {
      if (data.status === 200) {
        window.location.reload();
      }
      else
      {
        this.errorTypes = 1;
      }
    }); 
  }
}
