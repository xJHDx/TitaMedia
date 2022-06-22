import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DetalleDeudasComponent } from './detalle-deudas/detalle-deudas.component';
import { LogicoComponent } from './logico/logico.component';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {InputNumberModule} from 'primeng/inputnumber';

@NgModule({
  declarations: [
    DetalleDeudasComponent,
    LogicoComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ButtonModule,
    DropdownModule,
    FormsModule,
    TableModule,
    DialogModule,
    InputNumberModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DashboardModule { }
