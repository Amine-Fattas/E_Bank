import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../Service/client.service';
import { Client } from '../model/client';

@Component({
  selector: 'app-detail-client',
  templateUrl: './detail-client.component.html',
  styleUrls: ['./detail-client.component.css']
})
export class DetailClientComponent implements OnInit {
  public motCle: string;
  public client:Client;
  pageOperation: any = [];
  idClient: number;
  constructor(public activatedRoute:ActivatedRoute,public serviceOperation: OperationService,
    public router:Router,public serviceClient: ClientService) {
     this.idClient = activatedRoute.snapshot.params['id'];
   }

  ngOnInit(): void {
    this.serviceClient.getClient(this.idClient)
    .subscribe(data => {
      console.log(data)

     this.client = data;
   
     console.log(this.client.dateNaissance)},
    erreur => console.log(erreur)
    )
     }


 
  onTerminer(){
  window.location.href='/comptes/compteActive';
  }

}


/*
keyBoardEvent(e) {
  console.log(this.motCle);
  console.log(this.motCle.length);
  if ( this.motCle.length !== 0) {
    this.recherche();
  }
  else {
    this.listClient();
  }
}*/
