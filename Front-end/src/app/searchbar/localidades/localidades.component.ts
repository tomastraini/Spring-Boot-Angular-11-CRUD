import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-localidades',
  templateUrl: './localidades.component.html',
  styleUrls: ['./localidades.component.scss']
})
export class LocalidadesComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  
  cp: any;
  id_provincia: any;
  localidad: any;

  localidades: any;
  provincias: any;
  
  errorTypes = 0;
  @Input() busquedavalue: any;

  ngOnInit(): void
  {
    this.http.get(this.appComponent.apiUrl + 'Localidades',
    {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      this.localidades = data;
    });
    this.http.get(this.appComponent.apiUrl + 'Provincias',
    {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    })
    .subscribe(data => {
      this.provincias = data;
    });
  }


  modifyOpen(cp: any, id_provincia: any, localidad: any): void
  {
    this.cp = cp;
    this.id_provincia = id_provincia;
    this.localidad = localidad;
  }

  deleteOpen(cp: any): void
  {
    this.cp = cp;
  }

  insertLocalidad(): void
  {
    console.log(this.cp);
    console.log(this.id_provincia);
    console.log(this.localidad);
    
    if (this.cp == null || this.cp == '')
    {
      this.errorTypes = 1;
      return;
    }
    if(this.id_provincia == null || this.id_provincia == '')
    {
      this.errorTypes = 2;
      return;
    }
    if(this.localidad == null || this.localidad == '')
    {
      this.errorTypes = 3;
      return;
    }
    
    this.http.post(this.appComponent.apiUrl + 'Localidades', {
      cp: this.cp,
      id_provincia: this.id_provincia,
      localidad: this.localidad
    }, {observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
      }).subscribe(data => {
      if (data.status == 200)
      {
        window.location.reload();
      }
    });
    this.cp = null;
    this.id_provincia = null;
    this.localidad = null;
  }

  modifyLocalidad(): void
  {
    if (this.cp == null || this.cp == '')
    {
      this.errorTypes = 1;
      return;
    }
    if(this.id_provincia == null || this.id_provincia == '')
    {
      this.errorTypes = 2;
      return;
    }
    if(this.localidad == null || this.localidad == '')
    {
      this.errorTypes = 3;
      return;
    }

    this.http.put(this.appComponent.apiUrl + 'Localidades/', {
      cp: this.cp,
      localidad: this.localidad,
      id_provincia: this.id_provincia
    }, {observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })}).subscribe(data => {
      if (data.status == 200)
      {
        window.location.reload();
      }
    });
    this.cp = null;
    this.id_provincia = null;
    this.localidad = null;
  }

  deleteCliente(): void
  {
    this.http.delete(this.appComponent.apiUrl + 'Localidades/' + this.cp, {observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })}).subscribe(data => {
      if (data.status == 200)
      {
        window.location.reload();
      }
    });
    this.cp = null;
  }
}
