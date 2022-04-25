import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-abmproveedores',
  templateUrl: './abmproveedores.component.html',
  styleUrls: ['./abmproveedores.component.scss']
})
export class AbmproveedoresComponent implements OnInit {
  constructor(private appComponent: AppComponent, public http: HttpClient) { }

  @Input() busquedavalue: any;
  proveedores: any[] = [];
  localidades: any[] = [];
  id = 0;
  nombre = '';
  telefono = '';
  cp = 0;
  localidad = '';
  errorTypes = 0;

  ngOnInit(): void
  {
    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });

    this.http.get<any[]>(this.appComponent.apiUrl + 'Proveedores', { headers: headers }).subscribe(data => {
      this.proveedores = data;
      this.http.get<any[]>(this.appComponent.apiUrl + 'Localidades', { headers: headers }).subscribe(data => {
        this.localidades = data;
      });
    });
  }

  modifyOpen(id: any, razon_social: any, telefono: any, cp: any): void
  {
    this.id = id;
    this.nombre = razon_social;
    this.telefono = telefono;
    this.cp = cp;
  }

  deleteOpen(id: any): void
  {
    this.id = id;
  }

  insertProveedor(): void
  {
    this.http.post(this.appComponent.apiUrl + 'Proveedores', {
      razon_social_proveedor: this.nombre,
      telefono_proveedor: this.telefono,
      cp: this.cp
    }, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      if (data.status === 200)
      {
        window.location.reload();
      }
    });
  }

  modifyProveedor(): void
  {
    this.http.put(this.appComponent.apiUrl + 'Proveedores/', {
      id_proveedor: this.id,
      razon_social_proveedor: this.nombre,
      telefono_proveedor: this.telefono,
      cp: this.cp
    }, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      if (data.status === 200)
      {
        window.location.reload();
      }
    });
  }

  deleteProveedor(): void
  {
    this.http.delete(this.appComponent.apiUrl + 'Proveedores/' + this.id, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      if (data.status === 200)
      {
        window.location.reload();
      }
    });
  }

}
