import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-detalleventas',
  templateUrl: './detalleventas.component.html',
  styleUrls: ['./detalleventas.component.scss']
})
export class DetalleventasComponent implements OnInit, OnDestroy {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  ngOnDestroy(): void {
    sessionStorage.removeItem('id_forma_pago');
    sessionStorage.removeItem('id_cliente');
  }
  @Input() busquedavalue: any;
  productosAVender: any[] = [];

  clientes: any;
  id_cliente: any;
  FormasPago: any;
  id_forma_pago: any;
  usuario : any;

  id_producto: number = 0;
  id_venta: any;
  nombre_producto: any;
  importe: any;
  cantidad: any;
  importe_r: any;
  importe_total: any;

  productos: any[] = [];

  proveedores: any[] = [];

  showLoader: boolean = false;

  ngOnInit(): void
  {
    let formapago = sessionStorage.getItem('id_forma_pago');
    let cliente = sessionStorage.getItem('id_cliente');
    if(formapago === null || formapago === undefined || cliente === null || cliente === undefined)
    {
      window.location.href = '/';
    }

    let headers = new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    });
    
    this.http.get(this.appComponent.apiUrl + 'Clientes', { headers: headers }).subscribe(data => {
      this.clientes = data;
      this.id_cliente = sessionStorage.getItem('id_cliente');
      this.http.get(this.appComponent.apiUrl + 'FormasPago', { headers: headers }).subscribe(data => {
        this.FormasPago = data;
        this.id_forma_pago = sessionStorage.getItem('id_forma_pago');
      });
    });
    this.http.get<any[]>(this.appComponent.apiUrl + 'Productos/', { headers: headers }).subscribe(data => {
      this.productos = data;
    });

    this.http.get<any[]>(this.appComponent.apiUrl + 'Proveedores/', { headers: headers }).subscribe(data => {
      this.proveedores = data;
    });
  }

  selectProduct(id_producto: any): void
  {
    this.productos.forEach(element => {
      if (element.id_producto == id_producto)
      {
        this.importe = element.importe;
        this.cantidad = 1;
        this.importe_r = this.importe * this.cantidad;
        this.nombre_producto = element.descripcion;
      }
    });
  }

  updatePrices(): void
  {
    this.importe_r = this.importe * this.cantidad;
  }

  insertToList(): void
  {
    if(this.id_producto === undefined || this.id_producto === null ) { return; }
    if(this.cantidad === undefined || this.cantidad === null  ) { return; }
    if(this.importe === undefined || this.importe === null ) { return; }
    if(this.importe_r === undefined || this.importe_r === null ) { return; }
    if(this.nombre_producto === undefined || this.nombre_producto === null ) { return; }
    
    this.showLoader = true;
    var ID = this.id_producto++;
    this.productosAVender.push({
      id_producto: ID,
      producto: this.nombre_producto,
      cantidad: this.cantidad,
      importe: this.importe,
      importe_r: this.importe_r
    });
    this.cantidad = null;
    this.importe = null;
    this.importe_r = null;
    this.importe_total = this.productosAVender.reduce((a, b) => a + b.importe_r, 0);
    console.log(this.productosAVender);    
  }

  deleteFromList(id: any): void
  {
    this.productosAVender.forEach(element => {
      if (element.id_producto == id)
      {
        this.productosAVender.splice(this.productosAVender.indexOf(element), 1);
      }
    });
    if(this.productosAVender.length === 0)
    {
      this.showLoader = false;
    }
  }

  uploadDatabase(): void
  {
    var user = sessionStorage.getItem('x');
    this.http.post<any>(this.appComponent.apiUrl + 'Ventas', {
      id_cliente: this.id_cliente,
      id_forma_pago: this.id_forma_pago,
      id_usuario: user,
      importe: this.importe_total
    }, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + sessionStorage.getItem('token')
    })}).subscribe(data => {
      this.productosAVender.forEach(element => {
          this.http.post(this.appComponent.apiUrl + 'DetallesVentas', {
            id_venta: data.id_venta,
            id_producto: element.id_producto,
            cantidad: element.cantidad,
            importe: element.importe,
            importe_r: element.importe_r
          }, { headers: new HttpHeaders({
            'Authorization': 'Bearer ' + sessionStorage.getItem('token')
          }), observe: 'response'}).subscribe(data => {
            if (data.status === 200)
            {
              let descripcion = this.productos.find(x => x.id_producto == element.id_producto).descripcion;
              let proveedor = this.productos.find(x => x.id_producto == element.id_producto).proveedor;
              let id_proveedor = this.proveedores.find(x => x.razon_social_proveedor == proveedor).id_proveedor;
              let stock = this.productos.find(x => x.id_producto == element.id_producto).stock;
              let importe = this.productos.find(x => x.id_producto == element.id_producto).importe;
              let stockTotal = stock - element.cantidad;

              this.http.put(this.appComponent.apiUrl + 'Productos/', {
                id_producto: element.id_producto,
                descripcion: descripcion,
                id_proveedor: id_proveedor,
                stock: stockTotal,
                importe: importe,
              }, { headers: new HttpHeaders({
                'Authorization': 'Bearer ' + sessionStorage.getItem('token')
              }), observe: 'response'}).subscribe(data => {
                if (data.status === 200)
                {
                  this.showLoader = false;
                  alert('Venta realizada con exito');
                  sessionStorage.removeItem('id_forma_pago');
                  sessionStorage.removeItem('id_cliente');
                  window.location.href = '/';
                }
              });
            }
          });

      });
    });
    
  }

}
