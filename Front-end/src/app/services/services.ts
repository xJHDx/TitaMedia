import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})

export class ConfigService {

  constructor(private http: HttpClient) { }

  public getDetalleUsuario():Observable<any>{
    return this.http.get<any>( environment.apiBaseUrl + "detalleUsuario?id=1")
  }

}
