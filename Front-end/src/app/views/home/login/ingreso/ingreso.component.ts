import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ConfigService } from 'src/app/services/services';


@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.css']
})
export class IngresoComponent implements OnInit {

  profileForm = this.fb.group({
    userName:['', Validators.required],
    password:['', Validators.required]
  });

  mensajeError: boolean = false;
  mensajeTitulo: string = "";

  constructor(private router: Router,private fb: FormBuilder, private configService: ConfigService) { }

  ngOnInit(): void {

  }

  registrarBtn(){
    this.router.navigate(['portalbancario/login/registro']);

  }

  ingresarBtn(){
    this.configService.authUsuario(this.profileForm.value).subscribe(r=>{
      this.router.navigate(['portalbancario/dashboard/detalle']);
      this.configService.setInfoUsuario(r);
    },err=>{
      this.mensajeError = true;
      this.mensajeTitulo = err.error[0].description;
    }); 
    
  }



}
