import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DetalleDeudasComponent } from './detalle-deudas/detalle-deudas.component';
import { LogicoComponent } from './logico/logico.component';


@NgModule({
  declarations: [
    DetalleDeudasComponent,
    LogicoComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
