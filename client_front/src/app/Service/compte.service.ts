import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/Compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {
  constructor(private http:HttpClient){}

   _url = "http://localhost:8081/compte/CC/"
   hostTest = "http://localhost:8081/compte/CC/test"

  //_url = "https://ebank-client-back.herokuapp.com/compte/CC/"

getCompte(id:number){
  return this.http.get<Compte>(this._url+id)
}
// test(){
//   return this.http.get(this.hostTest);
// }

getCompteByRib(rib:String){
  return this.http.get<Compte>(this._url+"rib/"+rib)
}

getCurrentCompte(){
  return this.getCompte(10)
}



}
