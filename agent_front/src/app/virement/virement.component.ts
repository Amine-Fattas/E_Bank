import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {

  newOperation: Operation

  constructor(private _operationService: OperationService) { }

  ngOnInit(): void {}}
    /*this.init()
  }

  onSubmit(){
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
    this.newOperation.typeOperation = "Ag:Virement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = new Compte()
    this.newOperation.compteDestination = new Compte()
    this.newOperation.agent = new Agent()
    this.newOperation.agent.idAgent= 1
  }
}
*/