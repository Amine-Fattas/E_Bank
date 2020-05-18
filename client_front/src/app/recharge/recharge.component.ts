import { Component, OnInit } from '@angular/core';
import { Operation } from '../model/operation';
import { OperationService } from '../Service/operation.service';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';

@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.css']
})
export class RechargeComponent implements OnInit {

  newOperation: Operation


  constructor(private _operationService: OperationService) { }

  ngOnInit(): void {
    this.init()
  }

  onSubmit(){
    this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
    console.log("Succes Recharge \n"+this.newOperation)
    this._operationService.verser(this.newOperation)
              .subscribe(
                data => console.log("Success ! :", data),
                error => console.error("Error ! : ", error)
              )
  }



  init(){
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Recharge"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = null
    this.newOperation.compteDestination = new Compte() // Ici faut le compte actuelle
    this.newOperation.agent = new Agent()
    this.newOperation.agent.id = 1
    // Faut les info du compte actuelle en ligne
    this.newOperation.compteDestination.numCompte = 1
  }

}
