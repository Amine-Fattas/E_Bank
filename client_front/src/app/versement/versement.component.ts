import { Component, OnInit } from '@angular/core';
import { Operation } from '../model/operation';
import { Agent } from '../model/Agent';
import { OperationService } from '../Service/operation.service';
import { Compte } from '../model/Compte';

@Component({
  selector: 'app-versement',
  templateUrl: './versement.component.html',
  styleUrls: ['./versement.component.css']
})
export class VersementComponent implements OnInit {


  newOperation: Operation


  constructor(private _operationService: OperationService) { }

  ngOnInit(): void {
    this.init()
  }

  onSubmit(){
    this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
    console.log("Succes Versement \n"+this.newOperation)
    this._operationService.verser(this.newOperation)
              .subscribe(
                data => console.log("Success ! :", data),
                error => console.error("Error ! : ", error)
              )
  }



  init(){
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Versement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = null
    this.newOperation.compteDestination = new Compte()
    this.newOperation.agent = new Agent()
    this.newOperation.agent.id = 1
  }

}
