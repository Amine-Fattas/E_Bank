import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/Compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {
  constructor(private http:HttpClient){}

   _url = "http://localhost:8081/compte/CC/"
   _urlClient = "http://localhost:8082/compte/CC/"
   hostTest = "http://localhost:8081/compte/CC/test"

  //_url = "https://ebank-client-back.herokuapp.com/compte/CC/"

getCompte(id:number){
  return this.http.get<Compte>(this._urlClient+id)
}
// test(){
//   return this.http.get(this.hostTest);
// }

getCompteByRib(rib:String){
  return this.http.get<Compte>(this._urlClient+"rib/"+rib)
}


getCompteByIdClient(idClient: number){
  return this.http.get<Compte>(this._urlClient+"client/"+idClient)
}

getCurrentCompte(){
  return this.getCompte(10)
}



}
