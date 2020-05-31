import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private http:HttpClient){}
  _url = "http://localhost:8081/compte/CC/"

  getComptes(){
    return this.http.get("http://localhost:8081/compte/listCompteActive");  
  }

  chercherCompteA(motCle: String){
  return this.http.get("http://localhost:8081/compte/chercherA?mc="+motCle);
   }

   chercherCompteD(motCle: String){
    return this.http.get("http://localhost:8081/compte/chercherD?mc="+motCle);
     }

   desactiverCompte(compte: Compte){
    return this.http.put("http://localhost:8081/compte/desactiverCompte",compte);
     }
    getCompteDesactive(){
      return this.http.get("http://localhost:8081/compte/listCompteDesactive");
    }
    saveCompte(compte: Compte) {
      return this.http.post<Compte>("http://localhost:8081/compte/saveCompte",compte);
    }

    getCompteByRib(rib:String){
      return this.http.get<Compte>(this._url+"rib/"+rib)
    }

}
