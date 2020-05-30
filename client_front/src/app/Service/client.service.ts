import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http:HttpClient){}

  // _url = "https://ebank-client-back.herokuapp.com/client/"
  _url = "http://localhost:8082/"

  getClients(){
    return this.http.get(this._url+"client/listClient");
}

getClient(id:number){
  return this.http.get<Client>(this._url+"/client/"+id);
}

updateClient(client:Client){
  return this.http.put(this._url+"/client/update/"+client.id,client);
}

}
