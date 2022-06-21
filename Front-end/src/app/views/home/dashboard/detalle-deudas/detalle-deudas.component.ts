import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/services/services';

@Component({
  selector: 'app-detalle-deudas',
  templateUrl: './detalle-deudas.component.html',
  styleUrls: ['./detalle-deudas.component.css']
})
export class DetalleDeudasComponent implements OnInit {


  infoUsuario: any;

  constructor(private configService: ConfigService) { }

  ngOnInit(): void {
    this.configService.getInfoUsuario().subscribe(r=>{
      console.log(r)
    })
  }

}
