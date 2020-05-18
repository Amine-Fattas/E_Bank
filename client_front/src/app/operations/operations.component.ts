import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public motif:string;
  pageOperation:any;
  operationTest: any;

  constructor(private operationService: OperationService) { }
  // {"numOperation": 0, "type": "Retrait", "date": "11/11/2020", "acteur": "Agent","source": "CL1", "destination": "CL2", "montant": 200}
  ngOnInit(): void {
    this.operationService.getOperations()
        .subscribe(
          data =>{
            console.log("show : "+data);
            this.operationTest =<Operation>data;
            // if(this.operationTest.compteSource == null){
            //   this.operationTest.compteSource = new Compte()
            //   this.operationTest.compteSource.numCompte = 0
            // }
            // else if(this.operationTest.compteDestination == null){
            //   this.operationTest.compteDestination = new Compte()
            //   this.operationTest.compteDestination.numCompte = 0
            // }

            this.pageOperation = this.operationTest;
            console.log(this.operationTest)
          },
          error => console.error(error)
          )      
  }
    filter(op: Operation):any{
      

      return op
    }

}
