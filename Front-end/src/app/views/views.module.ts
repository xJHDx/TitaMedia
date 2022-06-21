import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ViewsRoutingModule } from './views-routing.module';
import { ConfigService } from '../services/services';


@NgModule({
  declarations: [  ],
  imports: [
    CommonModule,
    ViewsRoutingModule    
  ],
  providers:[ConfigService]
})
export class ViewsModule { }
