import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { RegistroComponent } from './registro/registro.component';
import { IngresoComponent } from './ingreso/ingreso.component';
import { SplitterModule } from 'primeng/splitter';
import { SharedModule } from 'primeng/api';
import { BrowserModule } from '@angular/platform-browser';
import {PasswordModule} from 'primeng/password';

@NgModule({
  imports: [
    CommonModule,
    LoginRoutingModule,
    SharedModule,
    SplitterModule,
    BrowserModule,
    PasswordModule
  ],
  declarations: [
    RegistroComponent,
    IngresoComponent    
  ],  
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LoginModule { }
