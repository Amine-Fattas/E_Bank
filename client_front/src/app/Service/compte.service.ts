import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Compte } from '../model/Compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {
  constructor(private http:HttpClient){}


getCompte(id:number){
  
}



}
