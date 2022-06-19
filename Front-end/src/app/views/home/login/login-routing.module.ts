import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngresoComponent } from './ingreso/ingreso.component';
import { RegistroComponent } from './registro/registro.component';

const routes: Routes = [
  {
    path:"auth",
    component: IngresoComponent
  },
  {
    path:"registro",
    component: RegistroComponent
  },
  { path:"**",  redirectTo:"auth" }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
