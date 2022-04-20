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

@NgModule({
  declarations: [
    AppComponent,
    AbmclientesComponent,
    MenuComponent,
    LocalidadesComponent,
    SearchbarComponent,
    PageNotFoundComponent,
    AboutComponent
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
