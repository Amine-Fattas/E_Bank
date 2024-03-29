import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// @ts-ignore
import {Compte} from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private http:HttpClient){}
  _url = "http://localhost:8081/compte/CC/"

  getComptes(){
    return this.http.get("http://localhost:8081/agent/listCompteActive");
  }

  chercherCompteA(motCle: String){
  return this.http.get("http://localhost:8081/agent/chercherA?mc="+motCle);
   }

   chercherCompteD(motCle: String){
     console.log("chercher compte");

    return this.http.get("http://localhost:8081/agent/chercherD?mc="+motCle);
     }

   desactiverCompte(compte: Compte){
    return this.http.put("http://localhost:8081/agent/desactiverCompte",compte);
     }

     activerCompte(compte:Compte){
       return this.http.put("http://localhost:8081/agent/activeCompte",compte);
     }

    getCompteDesactive(){
      return this.http.get("http://localhost:8081/agent/listCompteDesactive");
    }

    saveCompte(compte: Compte) {
      return this.http.post<Compte>("http://localhost:8081/agent/saveCompte",compte);
    }


    getCompteByRib(rib:String){
      return this.http.get<Compte>(this._url+"rib/"+rib)
    }

}
