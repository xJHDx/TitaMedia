import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path: 'login',
    loadChildren: () =>
      import('./home/login/login.module').then(
        (m) => m.LoginModule
      )
  }, 
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./home/dashboard/dashboard.module').then(
        (m) => m.DashboardModule
      )
  }, 
  {
    path: '**',
    redirectTo: 'login',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ViewsRoutingModule {}
