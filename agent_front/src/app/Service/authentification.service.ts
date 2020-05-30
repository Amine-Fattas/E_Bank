import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Agent } from '../model/Agent';


@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  
  private host:string="http://localhost:8081";
  constructor(private http:HttpClient) { }

  login(user){
    return  this.http.post(this.host+"/login",user,{'observe':'response'});
  }

  saveToken(jwt:string){
    localStorage.setItem('token',jwt);
  }

  currentAgent(){
   
   return this.http.get<Agent>(this.host+"/home/currentAgent");
  }

}




    



