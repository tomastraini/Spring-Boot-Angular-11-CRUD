import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-abmclientes',
  templateUrl: './abmclientes.component.html',
  styleUrls: ['./abmclientes.component.scss']
})
export class AbmclientesComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  clientes: any;
  localidades: any;
  id = 0;
  nombre = '';
  telefono = '';
  cp = 0;
  errorTypes = 0;
  @Input() busquedavalue: any;

  ngOnInit(): void
  {
    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });
    
    this.http.get(this.appComponent.apiUrl + 'Clientes', { headers: headers }).subscribe(data => {
      this.clientes = data;
    });
    this.http.get(this.appComponent.apiUrl + 'Localidades', { headers: headers }).subscribe(data => {
      this.localidades = data;
    });
  }

  insertCliente(): void
  {
    console.log(this.nombre);
    console.log(this.telefono);
    console.log(this.cp);
    if (this.nombre === '' || this.nombre === null ) { this.errorTypes = 1; return; }
    if (this.telefono === '' || this.telefono === null ) { this.errorTypes = 2; return; }
    this.http.post(this.appComponent.apiUrl + 'Clientes', {
      razon_social: this.nombre,
      telefono: this.telefono,
      cp: this.cp
    }, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }
    ).subscribe(data => {
      if(data.status === 200)
      {
        window.location.reload();
      }
       
    });
    this.id = 0;
    this.nombre = '';
    this.telefono = '';
    this.cp = 0;
    this.errorTypes = 0;
  }

  modifyCliente(): void
  {
    if (this.nombre === '' || this.nombre === null ) { this.errorTypes = 1; return; }
    if (this.telefono === '' || this.telefono === null ) { this.errorTypes = 2; return; }
    this.http.put(this.appComponent.apiUrl + 'Clientes/', {
      id_cliente: this.id,
      razon_social: this.nombre,
      telefono: this.telefono,
      cp: this.cp
    }, {
      observe: 'response',
      headers: new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      if(data.status === 200)
      {
        window.location.reload();
      }
    });
    this.id = 0;
    this.nombre = '';
    this.telefono = '';
    this.cp = 0;
    this.errorTypes = 0;
  }

  deleteCliente(): void
  {
    this.http.delete(this.appComponent.apiUrl + 'Clientes/' + this.id, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
        })
    }).subscribe(data => {
      if(data.status === 200)
      {
        window.location.reload();
      }
    });
    this.id = 0;
    this.nombre = '';
    this.telefono = '';
    this.cp = 0;
    this.errorTypes = 0;
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
}
