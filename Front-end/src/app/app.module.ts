import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AbmclientesComponent } from './searchbar/abmclientes/abmclientes.component';
import { MenuComponent } from './searchbar/menu/menu.component';
import { LocalidadesComponent } from './searchbar/localidades/localidades.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { PageNotFoundComponent } from './searchbar/page-not-found/page-not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AboutComponent } from './searchbar/about/about.component';
import { ClientesFilterPipe } from './Pipes/ClientesFilterPipe';
import { LocalidadesFilterPipe } from './Pipes/LocalidadesFilterPipe';
import { AbmprovinciasComponent } from './searchbar/abmprovincias/abmprovincias.component';
import { ProvinciasFilterPipe } from './Pipes/ProvinciasFilterPipe';
import { LoginComponent } from './login/login.component';

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
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
