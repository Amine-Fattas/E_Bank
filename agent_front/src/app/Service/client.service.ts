import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http:HttpClient){}

  private _url = "http://localhost:8081/"

  getClients(){
    return this.http.get(this._url+"client/list");
}

 chercherClient(motCle:String){
  return this.http.get("http://localhost:8081/agent/chercher/"+motCle);
}

getClient(id: number) {
  return this.http.get<Client>(this._url+"client/"+id);
}

updateClient(client: Client) {
  return this.http.put(this._url+"client/update/"+client.id,client);
}

deleteClient(id: number) {
  return this.http.delete(this._url+"client/delete/"+id);
}

saveClient(client: Client) {
  return this.http.post("http://localhost:8081/agent/ajoutClient",client);
}
sendEmailToClient(client: Client) {
  console.log("email")
  return this.http.post("http://localhost:8081/agent/send-email",client);
}

}
