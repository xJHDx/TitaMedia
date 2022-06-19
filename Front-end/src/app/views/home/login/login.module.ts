import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { RegistroComponent } from './registro/registro.component';
import { IngresoComponent } from './ingreso/ingreso.component';
import {ButtonModule} from 'primeng/button';
import {PasswordModule} from 'primeng/password';

@NgModule({
  declarations: [
    RegistroComponent,
    IngresoComponent    
  ],  
  imports: [
    CommonModule,
    LoginRoutingModule,
    ButtonModule ,
    PasswordModule   
  ]
})
export class LoginModule { }
