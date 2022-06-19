import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DetalleDeudasComponent } from './detalle-deudas/detalle-deudas.component';
import { LogicoComponent } from './logico/logico.component';
import {ButtonModule} from 'primeng/button';

@NgModule({
  declarations: [
    DetalleDeudasComponent,
    LogicoComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ButtonModule
  ]
})
export class DashboardModule { }
