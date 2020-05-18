import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http: HttpClient) { }

  logout(){
    console.log("logout")
    return   this.http.get("http://localhost:8081/logout");
  }
}
