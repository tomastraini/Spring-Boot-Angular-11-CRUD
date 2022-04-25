import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-abmprovincias',
  templateUrl: './abmprovincias.component.html',
  styleUrls: ['./abmprovincias.component.scss']
})
export class AbmprovinciasComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  @Input() busquedavalue: any;
  provincias: any[] = [];
  response: any;

  id_provincia: any;
  provincia: any;
  errorTypes = 0;

  ngOnInit(): void {
    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });
    this.http.get<any[]>(this.appComponent.apiUrl + 'Provincias',
    {
      headers: headers
    }).subscribe(data => {
      this.provincias = data;
    });
  }

  insertOpen(): void {
    this.id_provincia = '';
    this.provincia = '';
  }

  modifyOpen(id_provincia: any, provincia: any): void
  {
    this.id_provincia = id_provincia;
    this.provincia = provincia;
    document.getElementById('editProvincia')?.click();
  }

  deleteOpen(id_provincia: any): void
  {
    this.id_provincia = id_provincia;
  }

  insertProvincia(): void
  {
    let id_max = 0;
    this.provincias.forEach(element => {
      if (element.id_provincia > id_max)
      {
        id_max = element.id_provincia;
      }
    });

    this.http.post(this.appComponent.apiUrl + 'Provincias', {
      id_provincia: id_max + 1,
      provincia: this.provincia
    },
    {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      window.location.reload();
    });
    document.getElementById("cerrarModalBTN")?.click();
    this.provincia = null;
    this.id_provincia = null;
  }

  modifyProvincia(): void
  {
    this.http.put<any>(this.appComponent.apiUrl + 'Provincias', {
      id_provincia: this.id_provincia,
      provincia: this.provincia
    },
    {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })

    }).subscribe(data => {
      this.response = data;
      this.provincias.forEach(element => {
        if (element.id_provincia == this.response.id_provincia)
        {
          window.location.reload();
        }
    });
    });
    document.getElementById("cerrarModalBTNM")?.click();
    this.provincia = null;
    this.id_provincia = null;
  }

  deleteProvincia(): void
  {
    this.http.delete<any>(this.appComponent.apiUrl + 'Provincias/' + this.id_provincia,
    {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }
    ).subscribe(data => {
      this.response = data;
      this.provincias.forEach(element => {
        if (element.id_provincia == this.response.id_provincia)
        {
          window.location.reload();
        }
        });
      });
    
    document.getElementById("cerrarModalBTNE")?.click();
    this.provincia = null;
    this.id_provincia = null;
  }

}
