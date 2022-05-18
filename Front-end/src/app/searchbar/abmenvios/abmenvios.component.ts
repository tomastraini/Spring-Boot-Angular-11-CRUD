import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-abmenvios',
  templateUrl: './abmenvios.component.html',
  styleUrls: ['./abmenvios.component.scss']
})
export class AbmenviosComponent implements OnInit {

  constructor(private appComponent: AppComponent, public http: HttpClient) { }
  
  @Input() busquedavalue: any;
  @ViewChild('cerrarModalBTN') cerrarModalBTN: ElementRef | undefined;
  
  errorTypes = 0;
  loading = true;
  lang = this.appComponent.actualLang();

  envios: any;
  clientes: any;

  id_envio = 0;
  id_cliente = 0;
  telefono = '';
  fecha = '';
  direccion = '';
  costo = 0;
  localidad = '';
  cliente = '';

  ngOnInit(): void
  {
    this.http.get<any[]>(this.appComponent.apiUrl + 'Envios', 
    { 
      headers: new HttpHeaders({ 'Authorization': 'Bearer ' + sessionStorage.getItem('token') }) 
    }).subscribe(data => {
        this.envios = data;

        for(let i = 0; i < data.length; i++)
        {
          var today = new Date();
          var date = new Date(data[i].fecha);
          var timeDiff = Math.abs(date.getTime() - today.getTime());
          var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
          if(today.getTime() > date.getTime())
          {
            data[i].timeDiff = this.lang == 'es' ? 'Hace ' + diffDays + ' días' : diffDays + ' days ago';
          }
          else
          {
            data[i].timeDiff = this.lang == 'es' ? 'En ' + diffDays + ' días' : 'In ' + diffDays + ' days';
          }
          var date = new Date(data[i].fecha);
          var day = date.getDate().toString();
          var month = (date.getMonth() + 1).toString();
          var year = date.getFullYear().toString();
          var hours = (date.getHours() + 3).toString();
          var minutes = date.getMinutes().toString();
          
          if (day.length < 2) {
            day = '0' + day;
          }
          if (month.length < 2) {
            month = '0' + month;
          }
          if(hours.length < 2)
          {
            hours = '0' + hours;
          }
          if(minutes.length < 2)
          {
            minutes = '0' + minutes;
          }
          var dateString = day + '/' + month + '/' + year + ' ' + hours + ':' + minutes;
          data[i].fechaFormatted = dateString;
        }

        this.http.get(this.appComponent.apiUrl + 'Clientes',
        {
          headers: new HttpHeaders({ 'Authorization': 'Bearer ' + sessionStorage.getItem('token') })
        }).subscribe(data => {
          this.clientes = data;
          this.loading = false;
        });
    });
  }

  insertEnvio(): void
  {
    if (this.fecha === '' || this.fecha === null ) { this.errorTypes = 1; return; }
    if (this.telefono === '' || this.telefono === null ) { this.errorTypes = 2; return; }
    if (this.direccion === '' || this.direccion === null ) { this.errorTypes = 3; return; }
    if (this.costo === 0 || this.costo === null ) { this.errorTypes = 4; return; }
    if (this.id_cliente === 0 || this.id_cliente === null ) { this.errorTypes = 5; return; }

    var date = new Date(this.fecha);
    var year = date.getFullYear();
    var month = (date.getMonth() + 1).toString();
    var day = date.getDate().toString();
    var hours = date.getHours().toString();
    var minutes = date.getMinutes().toString();
    var seconds = date.getSeconds().toString();
    var milliseconds = date.getMilliseconds().toString();
    if (month.length === 1) { month = '0' + month; }
    if (day.length === 1) { day = '0' + day; }
    if (hours.length === 1) { hours = '0' + hours; }
    if (minutes.length === 1) { minutes = '0' + minutes; }
    if (seconds.length === 1) { seconds = '0' + seconds; }
    if (milliseconds.length === 1) { milliseconds = '0' + milliseconds; }

    var dateString = year + '-' + month + '-' + day + 'T' + hours + ':' + minutes + ':' + seconds + '+' + milliseconds;
    

    this.http.post(this.appComponent.apiUrl + 'Envios',
    {
      id_cliente: this.id_cliente,
      direccion: this.direccion,
      telefono: this.telefono,
      costo: this.costo,
      fecha: dateString
    },
    {
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
      else
      {
        this.errorTypes = 6;
      }
    });

    this.id_envio = 0;
    this.telefono = '';
    this.fecha = '';
    this.direccion = '';
    this.costo = 0;
    this.id_cliente = 0;
    this.errorTypes = 0;
  }

  modifyEnvio(): void
  {
    if (this.fecha === '' || this.fecha === null ) { this.errorTypes = 1; return; }
    if (this.telefono === '' || this.telefono === null ) { this.errorTypes = 2; return; }
    if (this.direccion === '' || this.direccion === null ) { this.errorTypes = 3; return; }
    if (this.costo === 0 || this.costo === null ) { this.errorTypes = 4; return; }
    if (this.id_cliente === 0 || this.id_cliente === null ) { this.errorTypes = 5; return; }
    
    this.http.put(this.appComponent.apiUrl + 'Envios/', {
      id_envio: this.id_envio,
      id_cliente: this.id_cliente,
      telefono: this.telefono,
      fecha: this.fecha,
      direccion: this.direccion,
      costo: this.costo
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
      else
      {
        this.errorTypes = 6;
      }
    });
    document.getElementById("cerrarModalBTN")?.click();
    this.cerrarModalBTN?.nativeElement.click();
  }

  deleteEnvio(): void
  {
    this.http.delete(this.appComponent.apiUrl + 'Envios/' + this.id_envio, {
      observe: 'response',
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      })
    }).subscribe(data => {
      if(data.status === 200)
      {
        window.location.reload();
      }
      else
      {
        this.errorTypes = 6;
      }
    });

  }


  modifyOpen(id_envio: any, telefono: any, 
    fecha: any, direccion: any, costo: any, id_cliente: any, cliente: any, localidad: any): void
  {
    this.id_envio = id_envio;
    this.telefono = telefono;
    this.direccion = direccion;
    this.costo = costo;
    this.id_cliente = id_cliente;
    this.cliente = cliente;
    this.localidad = localidad;
    this.fecha = fecha.substring(0, fecha.indexOf('T') + 6);
  }

  deleteOpen(id: any): void
  {
    this.id_envio = id;
  }

  openinsertEnvio(): void
  {
    this.id_envio = 0;
    this.telefono = '';
    this.fecha = '';
    this.direccion = '';
    this.costo = 0;
    this.id_cliente = 0;
  }

}
