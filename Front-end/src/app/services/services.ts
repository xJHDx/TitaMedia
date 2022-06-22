import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { RealizarPagoModels } from '../models/realizarPagoModels';


@Injectable({
    providedIn: 'root',
})

export class ConfigService {

  public subject:BehaviorSubject<any> = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) { }

  public setInfoUsuario(info:any){
    this.subject.next(info);     
  }

  public getInfoUsuario():Observable<any>{
    return this.subject.asObservable();
  }

  public authUsuario(json: any):Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    const body = JSON.stringify(json);
    return this.http.post<any>(environment.apiBaseUrl + "auth" , body, {'headers': headers } );
  }

  public getDetalleUsuario(usuarioId:number):Observable<any>{
    return this.http.get<any>(`${environment.apiBaseUrl}detalleUsuario?id=${usuarioId}` )
  }

  public setRealizarPago(json: RealizarPagoModels):Observable<any>{
    console.log(json)
    const headers = { 'content-type': 'application/json'}  
    const body = JSON.stringify(json);
    return this.http.post<any>(environment.apiBaseUrl + "RealizarPago" , body, {'headers': headers } )
  }

}
