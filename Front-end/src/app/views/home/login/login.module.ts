import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { RegistroComponent } from './registro/registro.component';
import { IngresoComponent } from './ingreso/ingreso.component';
import {ButtonModule} from 'primeng/button';
import {PasswordModule} from 'primeng/password';
import {SplitterModule} from 'primeng/splitter';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ToastModule} from 'primeng/toast';

@NgModule({
  declarations: [
    RegistroComponent,
    IngresoComponent    
  ],  
  imports: [
    CommonModule,
    LoginRoutingModule,
    ButtonModule,
    PasswordModule,
    SplitterModule,
    ReactiveFormsModule,
    HttpClientModule,
    MessagesModule,
    MessageModule,
    ToastModule
  ]
})
export class LoginModule { }
