import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-abmproductos',
  templateUrl: './abmproductos.component.html',
  styleUrls: ['./abmproductos.component.scss']
})
export class AbmproductosComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  @Input() busquedavalue: any;
  productos: any[] = [];

  id_producto: any;
  descripcion: any;
  proveedor: any;
  stock: any;
  importe: any;

  proveedores: any[] = [];
  id_proveedor: any;

  errorTypes = 0;

  ngOnInit(): void {
    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });
    this.http.get<any[]>(this.appComponent.apiUrl + 'Productos/', { headers: headers }).subscribe(data => {
      this.productos = data;
    });
    this.http.get<any[]>(this.appComponent.apiUrl + 'Proveedores', { headers: headers }).subscribe(data => {
      this.proveedores = data;
    });
  }

  openInsertModal(): void {
    this.id_producto = '';
    this.descripcion = '';
    this.proveedor = '';
    this.stock = '';
    this.importe = '';
    this.id_proveedor = '';
  }

  modifyOpen(id_producto: any, descripcion: any, proveedor: any, stock: any, importe: any): void
  {
    this.id_producto = id_producto;
    this.descripcion = descripcion;
    this.id_proveedor = this.proveedores.find(x => x.razon_social_proveedor == proveedor).id_proveedor;
    this.stock = stock;
    this.importe = importe;
  }

  deleteOpen(id: any): void
  {
    this.id_producto = id;
  }

  insertProducto(): void
  {
    this.http.post(this.appComponent.apiUrl + 'Productos', {
      descripcion: this.descripcion,
      id_proveedor: this.id_proveedor,
      stock: this.stock,
      importe: this.importe
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
    this.http.put(this.appComponent.apiUrl + 'Productos/', {
      id_producto: this.id_producto,
      descripcion: this.descripcion,
      id_proveedor: this.id_proveedor,
      stock: this.stock,
      importe: this.importe
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
    this.http.delete(this.appComponent.apiUrl + 'Productos/' + this.id_producto, {
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
