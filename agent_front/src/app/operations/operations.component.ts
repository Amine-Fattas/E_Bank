import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public motif:string;
  pageOperation:any=[];
  numOperation:number;

  constructor(private operationService: OperationService) { }

  ngOnInit(): void {
    // this.pageOperation = [
    //   {"numOperation": 0, "type": "Retrait", "date": "11/11/2020", "acteur": "Agent","source": "CL1", "destination": "CL2", "montant": 200}
    // ]

    this.operationService.getOperations()
        .subscribe(
          data =>{
            console.log("show : "+data);
            this.pageOperation =<Operation>data;
            // if(this.operationTest.compteSource == null){
            //   this.operationTest.compteSource = new Compte()
            //   this.operationTest.compteSource.numCompte = 0
            // }
            // else if(this.operationTest.compteDestination == null){
            //   this.operationTest.compteDestination = new Compte()
            //   this.operationTest.compteDestination.numCompte = 0
            // }

            console.log(this.pageOperation)
          },
          error => console.error(error)
          ) 
  }

}
