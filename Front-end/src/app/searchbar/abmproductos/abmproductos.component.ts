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
  productos: any;
  lang = this.appComponent.actualLang();

  id_producto: any;
  descripcion: any;
  proveedor: any;
  stock: any;
  importe: any;

  proveedores: any[] = [];
  id_proveedor = 0;

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
    this.id_proveedor = 0;
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
    if(this.descripcion == '' || this.descripcion == null || this.descripcion == undefined)
    {
      this.errorTypes = 1;
      return;
    }

    if(this.id_proveedor == 0 || this.id_proveedor == null || this.id_proveedor == undefined)
    {
      this.errorTypes = 2;
      return;
    }

    if(this.stock == '' || this.stock == null || this.stock == undefined)
    {
      this.errorTypes = 3;
      return;
    }

    if(this.importe == '' || this.importe == null || this.importe == undefined)
    {
      this.errorTypes = 4;
      return;
    }

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
    if(this.descripcion == '' || this.descripcion == null || this.descripcion == undefined)
    {
      this.errorTypes = 1;
      return;
    }

    if(this.id_proveedor == 0 || this.id_proveedor == null || this.id_proveedor == undefined)
    {
      this.errorTypes = 2;
      return;
    }

    if(this.stock == '' || this.stock == null || this.stock == undefined)
    {
      this.errorTypes = 3;
      return;
    }

    if(this.importe == '' || this.importe == null || this.importe == undefined)
    {
      this.errorTypes = 4;
      return;
    }
    
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
