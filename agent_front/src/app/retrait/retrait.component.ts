import { Component, OnInit } from '@angular/core';
import { Compte } from '../model/Compte';
import { Operation } from '../model/operation';
import { OperationService } from '../Service/operation.service';
import { AuthentificationService } from '../Service/authentification.service';
import { CompteService } from '../Service/compte.service';
import { Agent } from '../model/Agent';

@Component({
  selector: 'app-retrait',
  templateUrl: './retrait.component.html',
  styleUrls: ['./retrait.component.css']
})
export class RetraitComponent implements OnInit {

  newOperation: Operation
  _compte: Compte
  _agent: Agent

  constructor(private _operationService: OperationService,
              private _auth: AuthentificationService,
              private _compteService: CompteService) { }

  ngOnInit(): void {
    this.init()
    this._auth.currentAgent().subscribe(
      data => {
        this._agent = data
        console.log(this._agent)
      },
      error => console.error(error)
    )
  }

  onSubmit(){
    this.newOperation.agent = this._agent //this.compte.agent
    this._compteService.getCompteByRib(this._compte.rib).subscribe(
      data => {
        this._compte = data
        console.log(this._compte)
        this.newOperation.compteSource = this._compte
        this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
        console.log("Succes Retrait \n"+this.newOperation)
        this._operationService.retirer(this.newOperation)
              .subscribe(
                data => console.log("Success ! :", data),
                error => console.error("Error ! : ", error)
              )
      },
      error => console.error(error)
    )
    

    
    
  }

  init(){
    this._compte = new Compte()
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Retrait"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = new Compte()
    this.newOperation.compteDestination = null
    // this.newOperation.compteDestination = new Compte() // Ici faut le compte actuelle
    // this.newOperation.agent = new Agent()
    // this.newOperation.agent.id = 1
    // Faut les info du compte actuelle en ligne
    // this.newOperation.compteDestination.numCompte = 1
  }

}