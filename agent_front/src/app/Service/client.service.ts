import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http:HttpClient){}

  getClients(){
    return this.http.get("http://localhost:8081/agent/listClient");
}

 chercherClient(motCle:String){
  return this.http.get("http://localhost:8081/agent/chercher/"+motCle);
}

getClient(id: number) {
  return this.http.get<Client>("http://localhost:8081/agent/"+id);
}

updateClient(client: Client) {
  return this.http.put("http://localhost:8081/agent/update/"+client.id,client);
}

deleteClient(id: number) {
  return this.http.delete("http://localhost:8081/agent/delete/"+id);
}

saveClient(client: Client) {
  return this.http.post("http://localhost:8081/agent/ajoutClient",client);
}
sendEmailToClient(client: Client) {
  console.log("email")
  return this.http.post("http://localhost:8081/agent/send-email",client);
}

}
