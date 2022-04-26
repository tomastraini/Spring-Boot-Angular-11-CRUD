import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './searchbar/page-not-found/page-not-found.component';
import { AbmclientesComponent } from './searchbar/abmclientes/abmclientes.component';
import { LocalidadesComponent } from './searchbar/localidades/localidades.component';
import { MenuComponent } from './searchbar/menu/menu.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { AboutComponent } from './searchbar/about/about.component';
import { AbmprovinciasComponent } from './searchbar/abmprovincias/abmprovincias.component';
import { LoginComponent } from './login/login.component';
import { AbmproveedoresComponent } from './searchbar/abmproveedores/abmproveedores.component';
import { DetalleventasComponent } from './searchbar/detalleventas/detalleventas.component';
import { AbmproductosComponent } from './searchbar/abmproductos/abmproductos.component';
import { HistorialventasComponent } from './searchbar/historialventas/historialventas.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: SearchbarComponent,
    children:
    [
      {
        path: '',
        component: MenuComponent
      },
      {
        path: 'abmclientes',
        component: AbmclientesComponent
      },
      {
        path: 'abmlocalidades',
        component: LocalidadesComponent
      },
      {
        path: "abmprovincias",
        component: AbmprovinciasComponent
      },
      {
        path: 'about',
        component: AboutComponent
      },
      {
        path: 'abmproveedores',
        component: AbmproveedoresComponent
      },
      {
        path: 'vender',
        component: DetalleventasComponent
      },
      {
        path: 'abmproductos',
        component: AbmproductosComponent
      },
      {
        path: 'history',
        component: HistorialventasComponent
      },
    ]
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
