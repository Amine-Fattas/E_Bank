import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http:HttpClient){}

  getClients(){
    return this.http.get("http://localhost:8081/client/listClient");
}

 chercherClient(motCle:String){
  return this.http.get("http://localhost:8081/client/chercher/"+motCle);
}

getClient(id:number){
  return this.http.get<Client>("http://localhost:8081//client/"+id);
}

updateClient(client:Client){
  return this.http.put("http://localhost:8081//client/update/"+client.id,client);
}

deleteClient(id:number){
  return this.http.delete("http://localhost:8081/client/delete/"+id);
}

saveClient(client:Client){
  return this.http.post("http://localhost:8081/client/ajoutClient",client);
}

}
