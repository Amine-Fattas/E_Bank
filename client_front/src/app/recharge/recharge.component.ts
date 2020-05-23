import { Component, OnInit } from '@angular/core';
import { Operation } from '../model/operation';
import { OperationService } from '../Service/operation.service';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';
import { CompteService } from '../Service/compte.service';

@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.css']
})
export class RechargeComponent implements OnInit {

  newOperation: Operation
  compte: Compte
  codeRecharge: CodeRecharge


  constructor(private _operationService: OperationService,
              private _compteService: CompteService) { }

  ngOnInit(): void {
    this.init()
    this.codeRecharge = new CodeRecharge()
    this._compteService.getCompte(1).subscribe(
      data => {
        this.compte = data
        console.log(this.compte)
      },
      error => console.error(error)
    )

  }

  onSubmit(){
    this.newOperation.agent = this.compte.agent
    this.newOperation.compteDestination = this.compte
    this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
    console.log("Succes Recharge \n"+this.newOperation)
    this._operationService.recharge(this.newOperation, parseInt(this.codeRecharge.code))
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
    // this.newOperation.compteDestination = new Compte() // Ici faut le compte actuelle
    // this.newOperation.agent = new Agent()
    // this.newOperation.agent.id = 1
    // Faut les info du compte actuelle en ligne
    // this.newOperation.compteDestination.numCompte = 1
  }

}

export class CodeRecharge{
  code: string
  constructor(){}
}
