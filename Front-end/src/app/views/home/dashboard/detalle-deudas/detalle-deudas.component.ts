import { Component, OnInit,OnChanges, SimpleChanges } from '@angular/core';
import { SelectBancoModels } from 'src/app/models/selectBanco';
import { ConfigService } from 'src/app/services/services';

@Component({
  selector: 'app-detalle-deudas',
  templateUrl: './detalle-deudas.component.html',
  styleUrls: ['./detalle-deudas.component.css']
})
export class DetalleDeudasComponent implements OnInit, OnChanges {

  infoUsuario: any = {};
  detalleUsuario: any = {};
  selectBanco: any;
  btnPagar: boolean = true;
  panelDetalleDeuda: boolean = false;
  bancoSelect: any = {};
  displayModal: boolean = false;
  valorPagar: number = 0;
  constructor(private configService: ConfigService) { }
  
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }
  
  ngDoCheck(){
    if(this.selectBanco == null){
      this.btnPagar = true;
      this.panelDetalleDeuda = false;
    }
  }

  ngOnInit(): void {

    this.configService.getInfoUsuario().subscribe(r=>{
      this.infoUsuario = r;
      this.configService.getDetalleUsuario(r.usuariosId).subscribe(r=>{
        this.detalleUsuario = r;
        console.log(this.detalleUsuario);
      });
      
    });
    
  }

  abrirModalPagar(){
    console.log("abrir modal");
    this.displayModal = true;
    console.log(this.selectBanco);
  }
  consultarBanco(){

  this.bancoSelect = this.detalleUsuario.bancoEntities.find((element: any) => element.bancoId === this.selectBanco);
    	if(this.bancoSelect){
        this.panelDetalleDeuda = true;
      }
    console.log(this.bancoSelect)
    console.log(this.selectBanco);
    this.btnPagar = false;
  }

  realizarPago(){
    console.log("servicio de pago.")
  }

}
