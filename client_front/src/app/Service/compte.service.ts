import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/Compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {
  constructor(private http:HttpClient){}

  _url = "http://localhost:8081/compte/CC/"

getCompte(id:number){
  return this.http.get<Compte>(this._url+id)
}



}
