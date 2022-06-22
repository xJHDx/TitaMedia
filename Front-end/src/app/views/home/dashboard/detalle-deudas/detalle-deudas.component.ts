import { Component, OnInit,OnChanges, SimpleChanges } from '@angular/core';
import { RealizarPagoModels } from 'src/app/models/realizarPagoModels';
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
  realizarPagoModels: any = new RealizarPagoModels;
  pagoRealizado: any = {};
  constructor(private configService: ConfigService) { }
  
  ngOnChanges(changes: SimpleChanges): void {
    console.log("Changes")  
  }
  
  ngDoCheck(){
    if(this.selectBanco == null){
      this.btnPagar = true;
      this.panelDetalleDeuda = false;
    }
    this.consultarBanco();
    
  }

  ngOnInit(): void {
    this.allinfoUsuario();   
  }

  allinfoUsuario(){
    this.configService.getInfoUsuario().subscribe(r=>{
      this.infoUsuario = r;
      this.configService.getDetalleUsuario(r.usuariosId).subscribe(r=>{
        this.detalleUsuario = r;
      });
    });
  }

  abrirModalPagar(){
    console.log("abrir modal");
    this.displayModal = true;
  }

  consultarBanco(){
  this.bancoSelect = this.detalleUsuario.bancoEntities.find((element: any) => element.bancoId === this.selectBanco);
    	if(this.bancoSelect){
        this.panelDetalleDeuda = true;
      }
    this.btnPagar = false;
  }

  realizarPago(){
    this.realizarPagoModels.bancoId = this.bancoSelect.bancoId;
    this.realizarPagoModels.usuarioId = this.infoUsuario.usuariosId;
    this.realizarPagoModels.valorPagado = this.valorPagar;
    const fecha = new Date();
    this.realizarPagoModels.fechaPago = fecha.toLocaleDateString();

    this.configService.setRealizarPago(this.realizarPagoModels).subscribe(r=>{
      this.pagoRealizado = r;
      this.allinfoUsuario();
      this.consultarBanco();
    })
    this.displayModal = false;
    console.log("servicio de pago.");
    
  }

}
