import { Component, OnInit } from '@angular/core';
import { CompteService } from '../Service/compte.service';
import { OperationService } from '../Service/operation.service';
import Swal from 'sweetalert2';
import { Operation } from '../model/operation';
import { AuthentificationService } from '../Service/authentification.service';
import { Agent } from '../model/Agent';
import { Compte } from '../model/Compte';

@Component({
  selector: 'app-versement',
  templateUrl: './versement.component.html',
  styleUrls: ['./versement.component.css']
})
export class VersementComponent implements OnInit {

  newOperation: Operation
  _compte: Compte
  _agent: Agent

  constructor(private _operationService: OperationService,
              private _auth: AuthentificationService,
              private _compteService: CompteService) { }

  ngOnInit(): void {
    this.init()
    this._auth.currentAgent().subscribe(
      data => {
        this._agent = data
        console.log(this._agent)
      },
      error => console.error(error)
    )
  }

  onSubmit(){
    this.newOperation.agent = this._agent //this.compte.agent
    this._compteService.getCompteByRib(this._compte.rib).subscribe(
      data => {
       // this._compte = data
        console.log(data)
        this.newOperation.compteDestination = data
        this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
        console.log("Succes Versement \n"+this.newOperation)
        
        this._operationService.verser(this.newOperation)
              .subscribe(
                data =>  Swal.fire({
                  
                  title:"versement effectue par succes ",
                 
                  confirmButtonColor: 'black',
                  confirmButtonText: "OK",
                  width: 600
                  
                }).then(function(){
                  window.location.href = "/acceuil"})
                   , err => { Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: 'Compte n existe pas ou désactivé!',
                  confirmButtonColor: 'black'
                }).then(function(){
                  window.location.href = "/operations/versement";
                })
                   })
      
      }
    )
    

    
    
  }

  init(){
    this._compte = new Compte()
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Versement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant 
    this.newOperation.compteSource = null
    this.newOperation.compteDestination = new Compte()
  }

}
