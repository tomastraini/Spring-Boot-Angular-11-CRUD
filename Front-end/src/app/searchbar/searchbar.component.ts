import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {
  busquedavalue: any;
  view: any;
  id: any;

  clientes: any;
  id_cliente: any;
  FormasPago: any;
  id_forma_pago: any;
  usuario : any;
  id_usuario: any;

  constructor(public route: ActivatedRoute, public router: Router, private http: HttpClient, private appComponent: AppComponent) { }


  ngOnInit(): void
  {
    if(sessionStorage.getItem('token') === null || sessionStorage.getItem('token') === undefined)
    {
        window.location.href = '/login';
    }
    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });
    
    this.http.get(this.appComponent.apiUrl + 'Clientes', { headers: headers }).subscribe(data => {
      this.clientes = data;
      this.http.get(this.appComponent.apiUrl + 'FormasPago', { headers: headers }).subscribe(data => {
        this.FormasPago = data;
      });
    });

    this.view = this.router.url.replace(/^\/|\/$/g, '');
  }

  changeLang(lang: string)
  {
    this.appComponent.changeLanguage(lang);
  }

  goAbout(): void
  {
    window.location.href = '/about';
  }

  goAbmClientes(): void
  {
    window.location.href = '/abmclientes';
  }

  goAbmLocalidades(): void
  {
    window.location.href = '/abmlocalidades';
  }

  goAbmProvincias(): void
  {
    window.location.href = '/abmprovincias';
  }

  goAbmProveedores(): void
  {
    window.location.href = '/abmproveedores';
  }

  goVender(): void
  {
    window.location.href = '/vender';
  }

  goAbmProductos(): void
  {
    window.location.href = '/abmproductos';
  }

  goHistorialVentas(): void
  {
    window.location.href = '/history';
  }

  goEnvios(): void
  {
    window.location.href = '/abmenvios';
  }

  cerrarSession(): void
  {
    var lang = sessionStorage.getItem('lang');
    sessionStorage.clear();
    if(lang != null)
    {
      sessionStorage.setItem('lang', lang);
    }
    
    window.location.href = '/login';
  }

  insertVenta(): void
  {
    sessionStorage.setItem('id_cliente', this.id_cliente);
    sessionStorage.setItem('id_forma_pago', this.id_forma_pago);
    window.location.href = '/vender';
  }

}
