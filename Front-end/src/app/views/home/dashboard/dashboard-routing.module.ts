import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleDeudasComponent } from './detalle-deudas/detalle-deudas.component';
import { LogicoComponent } from './logico/logico.component';

const routes: Routes = [
  { path: "detalle" , component: DetalleDeudasComponent },
  { path: 'logico', component: LogicoComponent},
  { path:"**",  redirectTo:"detalle" }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
