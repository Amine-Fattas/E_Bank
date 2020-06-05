import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { CompteService } from '../Service/compte.service';
import { AuthentificationService } from '../Service/authentification.service';
import { Client } from '../model/client';

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
  client: Client

  constructor(private operationService: OperationService,
              private _compteService: CompteService,
              private _authentificationService: AuthentificationService) { }
  // {"numOperation": 0, "type": "Retrait", "date": "11/11/2020", "acteur": "Agent","source": "CL1", "destination": "CL2", "montant": 200}
  ngOnInit(): void {
    this._authentificationService.currentClient().subscribe(
      client => {
        this.client = client;
        console.log(this.client);
        this._compteService.getCompteByIdClient(this.client.id).subscribe(
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
      },
      error => console.error(error)
    )

    
        
  }
    filter(op: Operation):any{
      

      return op
    }

}
