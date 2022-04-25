import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
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

  constructor(public route: ActivatedRoute, public router: Router, private http: HttpClient, private appComponent: AppComponent) { }


  ngOnInit(): void
  {
    if(sessionStorage.getItem('token') === null || sessionStorage.getItem('token') === undefined)
    {
        window.location.href = '/login';
    }
    if (this.router.url === '/')
    {
      this.view = '';
    }
    else if (this.router.url.includes('search'))
    {
      this.view = 'search';
    }
    else if (this.router.url.includes('about'))
    {
      this.view = 'about';
    }
    else if (this.router.url.includes('abmclientes'))
    {
      this.view = 'abmclientes';
    }
    else if (this.router.url.includes('abmlocalidades'))
    {
      this.view = 'abmlocalidades';
    }
    else if (this.router.url.includes('abmprovincias'))
    {
      this.view = 'abmprovincias';
    }
    else if (this.router.url.includes('abmproveedores'))
    {
      this.view = 'abmproveedores';
    }
    else
    {
      this.view = 'pagenotfound';
    }
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

  cerrarSession(): void
  {
    sessionStorage.clear();
    window.location.href = '/login';
  }

}
