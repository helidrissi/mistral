import {AddUserComponent} from './users/add-user/add-user.component';


import {AccueilComponent} from './accueil/Accueil.component';
import {PageNotFoundComponent} from './partials/page-not-found/page-not-found.component';
import {LoginComponent} from './login/login.component';

import {AdministrationComponent} from './administration/administration.component';

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from '../app/guards/auth.guard';
import {AfterAuthGuard} from '../app/guards/after-auth.guard'

const routes: Routes = [


  {path: '', redirectTo: "/accueil", pathMatch: "full", canActivate: [AuthGuard]},
  {path: 'accueil', component: AccueilComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent, canActivate: [AfterAuthGuard]},
  {path: 'parametre', component: AdministrationComponent, canActivate: [AuthGuard]},
  {path: 'addUser', component: AddUserComponent, canActivate: [AuthGuard]},


  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
