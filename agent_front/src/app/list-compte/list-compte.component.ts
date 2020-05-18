import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CompteService } from '../Service/compte.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-list-compte',
  templateUrl: './list-compte.component.html',
  styleUrls: ['./list-compte.component.css']
})
export class ListCompteComponent implements OnInit {
  public motCle:string="";
  public pageCompte:any=[];
  public page:number=0;
  public desactivationReussite:boolean;
  constructor(public httpClient:HttpClient,public compteService:CompteService) { }

  ngOnInit(): void {
   this.listCompte();
  }

  onDesactiver(c){
   
    Swal.fire({
      title: 'Vous etes sur ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Non',
      confirmButtonText: 'Oui désactivé !'
    }).then((result) => {
      if (result.value) {
        
       Swal.fire(
        'Désactivation avec succés',
        'success'
      )
      this.compteService.desactiverCompte(c)
     . subscribe((data:boolean)=>{
       this.desactivationReussite=data;
      console.log(this.desactivationReussite);
      this.pageCompte.splice(
        this.pageCompte.indexOf(c),1
      );
     },
        err=>{ Swal.fire(
          'Erreur non désactivé')})
       
      }
    })
  
  }
  

  chercher(){
    this.listCompte();
  }
  
  listCompte(){
    this.compteService.getComptes()
    .subscribe((data:any)=>{
      this.pageCompte=data;
      console.log(data);
      },(error)=>console.log(error));
  }

  recherche(){
    this.compteService.chercherCompteA(this.motCle)
    .subscribe((data:any)=>{
     this.pageCompte=data;
     
     if(this.pageCompte.length==0){
        Swal.fire(
          'Aucun enregistrement n est trouvé')}
      },(error)=>console.log(error));
     
  }

  keyBoardEvent(e){
    if(this.motCle.length != 0){
      this.recherche();
    }
    else{
      this.listCompte();
    }
  }




  

}
