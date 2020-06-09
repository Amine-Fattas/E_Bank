import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public motif:string;
  pageOperation:any=[];
  numOperation:number;
  motCle:string;

  constructor(private operationService: OperationService, public router:Router) { }

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

  keyBoardEvent(e) {
    console.log(this.motCle);
    console.log("event")
    console.log(this.motCle.length);
    if ( this.motCle.length !== 0) {
      this.recherche();
    }
    else {
      this.listOperation();
    }
  }
  listOperation(){
    console.log('list')
    this.operationService.getOperations()
    .subscribe((data)=>{
      this.pageOperation=data;
       }),(error)=> err=>{
         console.log("errrrrre")
        this.router.navigateByUrl("/login");
      }
    }

  recherche() {
    this.operationService.chercherOperation(this.motCle)
    .subscribe((data: any) => {
     this.pageOperation = data;
     console.log(data)
     if (data.length==0) {
       console.log("vide")
        Swal.fire(
          'Aucun enregistrement n est trouvé')}
      } , ( error) => console.log(error));
  }

}
