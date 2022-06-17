import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'portalbancario',
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./home/login/login-routing.module').then(
        (m) => m.LoginRoutingModule
      ),
  },
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./home/dashboard/dashboard.module').then(
        (m) => m.DashboardModule
      ),
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
