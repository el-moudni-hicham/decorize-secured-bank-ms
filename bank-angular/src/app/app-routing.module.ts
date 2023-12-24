import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { AccountComponent } from './account/account.component';
import {AuthGuard} from "./guard/auth-guard.guard";

const routes: Routes = [
  { path: 'home', component: AccountComponent},
  { path: 'customers', component: CustomerComponent},
  { path: 'accounts', component: AccountComponent, canActivate : [AuthGuard], data : {roles:['ADMIN']}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
