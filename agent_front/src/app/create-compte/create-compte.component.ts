import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { Compte } from '../model/compte';
import Swal from 'sweetalert2';

import { CompteService } from '../Service/compte.service';
import { LoginService } from '../Service/login.service';
import { Agent } from '../model/Agent';
import { AgentService } from '../Service/agent.service';
import { ClientService } from '../Service/client.service';


@Component({
  selector: 'app-create-compte',
  templateUrl: './create-compte.component.html',
  styleUrls: ['./create-compte.component.css']
})
export class CreateCompteComponent implements OnInit {

   client:Client=new Client();
   compte:Compte=new Compte();
   agent:Agent;

  constructor(private agentService:AgentService,
    private compteService:CompteService,
    private loginService:LoginService,
    private clientService: ClientService) { }

  ngOnInit(): void {
    this.agentService.currentAgent.subscribe(
      agent => this.agent = agent,
      err=>Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Veuillez se connecté !',
        
      }) 
    )
    //  let clients = this.agentService.observable.subscribe(clients => console.log(clients));
  //  this.agentService.currentAgent.subscribe(agent=> this.agent = agent);
 
   console.log(this.agent) 
   this.compte.agent=this.agent;
   

  }

  saveClient(client){
    this.clientService.saveClient(this.client).subscribe(res=>console.log("done"));
  }

  onSave(form){
    this.saveClient(this.client); 
  /*this.compteService.saveCompte(this.compte)
    .subscribe(response=> console.log(response));*/
  //this.clientService.saveClient(this.client).subscribe(res=>console.log(res));
  this.compte.client=this.client;
  this.compteService.saveCompte(this.compte)
    .subscribe(response=>{  Swal.fire(
      'Ajout du compte par succes' ,
      'success'
    )},err=>{ Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Compte non sauvegardé !',
       // mzl mabanch lia imta kaymchi lroutage
      // fchkl katmchi dghia ms hia kayna hadi
    })  

    });

 

  }

  numericOnly(event): boolean { // restrict e,+,-,E characters in  input type number
    debugger
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode == 101 || charCode == 69 || charCode == 45 || charCode == 43) {
      return false;
    }
    return true;

  }

}
