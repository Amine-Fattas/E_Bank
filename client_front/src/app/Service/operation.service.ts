import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Operation } from '../model/operation';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

   _url = "http://localhost:8082/operation/"
   //_url ="https://ebank-client-back.herokuapp.com/operations"
  constructor(private http: HttpClient) { }

  getOperations(){
    return this.http.get(this._url+"list")
  }

  getOperation(idClient: number){
    return this.http.get(this._url+"listOperation/"+idClient)
  }

  verser(operation: Operation){
    return this.http.post<any>(this._url+"versement", operation)
  }

  retirer(operation: Operation){
    return this.http.post<any>(this._url+"retrait", operation)
  }

  virer(operation: Operation){
    return this.http.post<any>(this._url+"virement", operation)
  }

  recharge(operation: Operation, codeRacharge:number){
    return this.http.post<any>(this._url+"recharge/"+codeRacharge, operation)
  }

  
}
