import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';
import { AgentService } from '../Service/agent.service';
import { CompteService } from '../Service/compte.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';


@Component({
  selector: 'app-multi-form',
  templateUrl: './multi-form.component.html',
  styleUrls: ['./multi-form.component.css']
})
export class MultiFormComponent implements OnInit {
  client: Client = new Client();
  compte: Compte = new Compte();
  nouveauCompte: Compte;
  currentAgent: Agent;
  nextS1: boolean = false;
  nextS2: boolean = false;

  constructor(private agentService: AgentService,
     private compteService: CompteService ,
     private router: Router) { }

    ngOnInit(): void {
      this.agentService.currentAgent.subscribe(
        agent => this.currentAgent = agent,
        err => Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Veuillez se connecté !',
              }));
      if (Object.keys(this.currentAgent).length === 0) { this.router.navigateByUrl('/login');}
      else { this.compte.agent = this.currentAgent;}
    }

    numericOnly(event): boolean { // restrict e,+,-,E characters in  input type number
      const charCode = (event.which) ? event.which : event.keyCode;
      if (charCode === 101 || charCode === 69 || charCode === 45 || charCode === 43) {
        return false;
      }
      return true;
    }

    onNextStep1() {
      this.compte.client = this.client;
      this.nextS1 = true;
    }
    onTerminer(){ window.location.href = "/listClient";}

  onNextStep2() {
    
  this.compteService.saveCompte(this.compte)
    .subscribe(response => {
      this.nouveauCompte = response;
     
    
    });
    this.nextS2 = true;
    
  }

}
