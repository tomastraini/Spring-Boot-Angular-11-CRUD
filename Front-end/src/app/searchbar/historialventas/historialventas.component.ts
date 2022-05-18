import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-historialventas',
  templateUrl: './historialventas.component.html',
  styleUrls: ['./historialventas.component.scss']
})
export class HistorialventasComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  @Input() busquedavalue: any;
  lang = this.appComponent.actualLang();

  ventas: any[] = [];
  detalleventas: any[] = [];

  detalleventasfiltered: any[] = [];
  total: number = 0;

  searcher: string = "";

  ngOnInit(): void
  {
    this.http.get<any[]>(this.appComponent.apiUrl + 'Ventas',
    {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      this.ventas = data;
      this.ventas.forEach(element => {
        element.fecha_final = new Date(element.fecha).toLocaleDateString();
      });
    });

    this.http.get<any[]>(this.appComponent.apiUrl + 'DetallesVentas',
    {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      this.detalleventas = data;
    });
  }

  openModal(id_venta: any): void
  {
    this.detalleventasfiltered = this.detalleventas.filter(x => x.id_venta === id_venta);
    
  }

  filterTable(): void
  {
    this.detalleventasfiltered.filter(val =>
        val.producto.indexOf(this.searcher) !== -1 ||
        val.producto.toLowerCase().indexOf(this.searcher.toLowerCase()) !== -1
      )
  }
}
