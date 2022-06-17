import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { RegistroComponent } from './registro/registro.component';
import { IngresoComponent } from './ingreso/ingreso.component';

@NgModule({
  declarations: [
    RegistroComponent,
    IngresoComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule
  ]
})
export class LoginModule { }
