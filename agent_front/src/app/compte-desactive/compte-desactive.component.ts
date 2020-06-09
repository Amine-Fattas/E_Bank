import { Component, OnInit } from '@angular/core';
import { CompteService } from '../Service/compte.service';
import { Compte } from '../model/compte';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-compte-desactive',
  templateUrl: './compte-desactive.component.html',
  styleUrls: ['./compte-desactive.component.css']
})
export class CompteDesactiveComponent implements OnInit {
  pageCompte:Array<Compte>;
  motCle:string="";
  activationReussite:any;
  constructor(public compteService:CompteService) { }

  ngOnInit(): void {
    this.listCompteDesactive();
  }
  onActiver(c){Swal.fire({
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

    this.compteService.activerCompte(c)
   . subscribe((data:boolean)=>{
     this.activationReussite=data;
    console.log(this.activationReussite);
    this.pageCompte.splice(
      this.pageCompte.indexOf(c),1
    );
    window.location.href = "comptes/compteActive"
   },
      err=>{ Swal.fire(
        'Erreur non désactivé')})
     
    }
  })}
  listCompteDesactive(){
    this.compteService.getCompteDesactive()
    .subscribe((data:any)=>{
      this.pageCompte=data;
      console.log(data);
      },(error)=>console.log(error));
  }

  recherche(){
    console.log(this.motCle);
    this.compteService.chercherCompteD(this.motCle)
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
      this.listCompteDesactive();
    }
  }

}
