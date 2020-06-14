import { Component, OnInit } from '@angular/core';
import { CompteService } from '../Service/compte.service';
import { Compte } from '../model/Compte';
import { Client } from '../model/client';
import { Agent } from '../model/Agent';

import { AuthentificationService } from '../Service/authentification.service';

@Component({
  selector: 'app-compte-courant',
  templateUrl: './compte-courant.component.html',
  styleUrls: ['./compte-courant.component.css']
})
export class CompteCourantComponent implements OnInit {

  constructor(private _compteService: CompteService,
              private _authentificationService: AuthentificationService) { }

  compte: Compte
  client: Client

  ngOnInit(): void {
    this.compte = new Compte()
    this.compte.client = new Client()
    this.compte.agent = new Agent()
    this._authentificationService.currentClient().subscribe(
      client => {
        this.client = client;
        console.log(client);
        this._compteService.getCompteByIdClient(this.client.id).subscribe(
          data => {
            this.compte = data
            console.log(this.compte)
            this.compte.client = this.client
          },
          error => console.error(error)
        )
      }
    )
  }
 


}
