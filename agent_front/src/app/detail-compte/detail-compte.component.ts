import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OperationService } from '../Service/operation.service';

@Component({
  selector: 'app-detail-compte',
  templateUrl: './detail-compte.component.html',
  styleUrls: ['./detail-compte.component.css']
})
export class DetailCompteComponent implements OnInit {
  listOperation:any = [];
  idCompte:number;
  motCle:string;
  constructor(public activatedRoute:ActivatedRoute,public serviceOperation: OperationService,
    
    public router:Router) { }

  ngOnInit(): void {
    console.log("operation du compte idCompte")
    this.idCompte = this.activatedRoute.snapshot.params['id'];
    console.log(this.idCompte);
    this.afficherList();
  }

  afficherList() {
    console.log("afficher list")
    console.log(this.idCompte);
    this.serviceOperation.getOperationsParCompte(this.idCompte)
    .subscribe(data => {
      console.log(data)
     this.listOperation = data;
    },
    erreur => console.log(erreur)
    );
  }
 

  
  


}
