import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { CompteService } from '../Service/compte.service';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public motif:string;
  pageOperation:any;
  operationTest: any;
  compte: Compte

  constructor(private operationService: OperationService,
              private _compteService: CompteService) { }
  // {"numOperation": 0, "type": "Retrait", "date": "11/11/2020", "acteur": "Agent","source": "CL1", "destination": "CL2", "montant": 200}
  ngOnInit(): void {
    this._compteService.getCurrentCompte().subscribe(
      data => {
        this.compte = data
        console.log(this.compte)

        this.operationService.getOperation(this.compte.numCompte)
        .subscribe(
          data =>{
            console.log("show : "+data);
            this.operationTest =<Operation>data;

            this.pageOperation = this.operationTest;
            console.log(this.operationTest)
          },
          error => console.error(error)
          )  

      },
      error => console.error(error)
    )
        
  }
    filter(op: Operation):any{
      

      return op
    }

}
