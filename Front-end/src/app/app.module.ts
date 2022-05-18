import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AbmclientesComponent } from './searchbar/abmclientes/abmclientes.component';
import { MenuComponent } from './searchbar/menu/menu.component';
import { LocalidadesComponent } from './searchbar/localidades/localidades.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { PageNotFoundComponent } from './searchbar/page-not-found/page-not-found.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AboutComponent } from './searchbar/about/about.component';
import { ClientesFilterPipe } from './Pipes/ClientesFilterPipe';
import { LocalidadesFilterPipe } from './Pipes/LocalidadesFilterPipe';
import { AbmprovinciasComponent } from './searchbar/abmprovincias/abmprovincias.component';
import { ProvinciasFilterPipe } from './Pipes/ProvinciasFilterPipe';
import { LoginComponent } from './login/login.component';
import { AbmproveedoresComponent } from './searchbar/abmproveedores/abmproveedores.component';
import { ProveedoresFilterPipe } from './Pipes/ProveedoresFilterPipe';
import { DetalleventasComponent } from './searchbar/detalleventas/detalleventas.component';
import { ProductosFilterPipe } from './Pipes/ProductosFilterPipe';
import { AbmproductosComponent } from './searchbar/abmproductos/abmproductos.component';
import { ProductosTableFilterPipe } from './Pipes/ProductosTableFilterPipe';
import { HistorialventasComponent } from './searchbar/historialventas/historialventas.component';
import { HistorialFilterPipe } from './Pipes/HistorialFilterPipe';
import { detalleVentaFilterPipe } from './Pipes/detalleVentaFilterPipe';
import { AbmenviosComponent } from './searchbar/abmenvios/abmenvios.component';
import { EnviosFilterPipe } from './Pipes/EnviosFilterPipe';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { EnvService } from './Services/env.service';

@NgModule({
  declarations: [
    AppComponent,
    AbmclientesComponent,
    MenuComponent,
    LocalidadesComponent,
    SearchbarComponent,
    PageNotFoundComponent,
    AboutComponent,
    ClientesFilterPipe,
    LocalidadesFilterPipe,
    AbmprovinciasComponent,
    ProvinciasFilterPipe,
    LoginComponent,
    AbmproveedoresComponent,
    ProveedoresFilterPipe,
    DetalleventasComponent,
    ProductosFilterPipe,
    AbmproductosComponent,
    ProductosTableFilterPipe,
    HistorialventasComponent,
    HistorialFilterPipe,
    EnviosFilterPipe,
    detalleVentaFilterPipe,
    AbmenviosComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: (http: HttpClient) => {
              return new TranslateHttpLoader(http, '', '.json');
          },
          deps: [HttpClient],
      },
  }),
  ],
  providers: [EnvService],
  bootstrap: [AppComponent]
})
export class AppModule { }
