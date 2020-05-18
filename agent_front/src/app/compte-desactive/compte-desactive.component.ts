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

  constructor(public compteService:CompteService) { }

  ngOnInit(): void {
    this.listCompteDesactive();
  }

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
