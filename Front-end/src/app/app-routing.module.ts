import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'portalbancario',
    pathMatch: 'full',
  },
  {
    path: 'portalbancario',
    loadChildren: () =>
      import('./views/views.module').then((m) => m.ViewsModule),
  },
  {
    path: '**',
    redirectTo: 'portalbancario',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
