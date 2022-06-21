import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ConfigService } from 'src/app/services/services';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.css'],
  providers:[ConfigService]
})
export class IngresoComponent implements OnInit {

  profileForm = this.fb.group({
    user:['', Validators.required],
    password:['', Validators.required]
  });

  constructor(private router: Router,private fb: FormBuilder, private configService: ConfigService) { }

  ngOnInit(): void {
    
  }

  registrarBtn(){
    this.router.navigate(['portalbancario/login/registro']);

  }

  ingresarBtn(){
    this.configService.getDetalleUsuario();
    console.log(this.configService.getDetalleUsuario().subscribe(r=>{
      console.log(r);
    }));
    console.log(this.profileForm)
  }

}
