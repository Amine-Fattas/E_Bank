import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';
import { CompteService } from '../Service/compte.service';
import { AuthentificationService } from '../Service/authentification.service';
import { Client } from '../model/client';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {

  newOperation: Operation
  compte: Compte
  client: Client

  constructor(private _operationService: OperationService,
              private _compteService: CompteService,
              private _authentificationService: AuthentificationService) { }

  ngOnInit(): void {
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
    this.init()
  }

  onSubmit(){
    this.newOperation.compteSource.numCompte = this.compte.numCompte
    this.newOperation.agent = null
    this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
    console.log("Succes Virement \n"+this.newOperation)
    this._operationService.virer(this.newOperation)
              .subscribe(
                data => console.log("Success ! :", data),
                error => console.error("Error ! : ", error)
              )
  }

  init(){
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Virement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = new Compte()
    this.newOperation.compteDestination = new Compte()
  }
}
