import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';


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

  public getDetalleUsuario():Observable<any>{
    return this.http.get<any>( environment.apiBaseUrl + "detalleUsuario?id=1")
  }

  public authUsuario(json: any):Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    const body = JSON.stringify(json);
    return this.http.post<any>(environment.apiBaseUrl + "auth" , body, {'headers': headers } );
  }

}
