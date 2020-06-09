import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detail-client',
  templateUrl: './detail-client.component.html',
  styleUrls: ['./detail-client.component.css']
})
export class DetailClientComponent implements OnInit {
  public motCle: string;
  pageOperation: any = [];
  idClient: number;
  constructor(public activatedRoute:ActivatedRoute,public serviceOperation: OperationService,
    public router:Router) {
     this.idClient = activatedRoute.snapshot.params['id'];
   }

  ngOnInit(): void { console.log("listeOperation")
    this.afficherList(); }


  afficherList() {
    console.log(this.idClient);
    this.serviceOperation.getOperationsParClient(this.idClient)
    .subscribe(data => {
     this.pageOperation = data;
    },
    erreur => console.log(erreur)
    );
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
