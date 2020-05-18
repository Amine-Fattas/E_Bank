import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClientService } from '../Service/client.service';
import Swal from 'sweetalert2';

import { Router, ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
 public motCle:string;
 //public page:number=0;

 pageClient:any=[];
 //pages:number;
 idClient:number;
 
 
 constructor(public http:HttpClient,public clientService:ClientService,
  public router:Router, public activatedRoute:ActivatedRoute) { 

  }

  ngOnInit(): void {
   this.listClient();
  }

  listClient(){
    this.clientService.getClients()
    .subscribe((data:any)=>{
     
      this.pageClient=data;
      
      },(error)=>console.log(error));
  }
  

  onEditClient(id:number){
   this.router.navigate(['editClient',id]);
 }

 onDetailClient(id:number){
  this.router.navigate(['detailsClient',id]);
 }

 onDeleteClient(client:Client){
  Swal.fire({
    title: 'Vous etes sur?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    cancelButtonText: 'Non',
    confirmButtonText: 'Oui supprimé !'
  }).then((result) => {
    if (result.value) {
      
     Swal.fire(
      'Suprression avec succés',
      'success'
    )
      this.clientService.deleteClient(client.id)
     .subscribe(data=>{
      console.log(this.pageClient.indexOf(client))
       this.pageClient.splice(
        this.pageClient.indexOf(client),1);
      },
      err=>{ Swal.fire(
        'Erreur non supprime')})
     
    }
  })
}

/*goPages(){
 this.clientService.getClients()
  .subscribe((data:any)=>{
    this.pageClient=data;
    },(error)=>console.log(error));

}*/


keyBoardEvent(e){
  console.log(this.motCle);
  console.log(this.motCle.length);
  if(this.motCle.length != 0){
    this.recherche();
  }
  else{
    this.listClient();
  }
}

recherche(){
 
  this.clientService.chercherClient(this.motCle)
  .subscribe((data:any)=>{
   this.pageClient=data;
   //this.pages=data.totalPages;
   if(data.empty){
      Swal.fire(
        'Aucun enregistrement n est trouvé')}
    },(error)=>console.log(error));
   
}


/*goNext(){
 
  if(this.page < this.pages){
    this.page=this.page+1;
    this.goPages();
  }
 
}

goPrevious(){
 
  if(this.page >0){
  this.page=this.page-1;
  this.goPages();
  }

  }*/
}

 
  


