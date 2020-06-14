import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { Agent } from '../model/Agent';
import { AuthentificationService } from '../Service/authentification.service';
import { CompteService } from '../Service/compte.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {

  newOperation: Operation
  _compteSource: Compte
  _compteDestination: Compte
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
   /* this._compteService.getCompteByRib(this._compteSource.rib).subscribe(
      data => {
        this._compteSource = data
        console.log(this._compteSource)
        // CompteDestination
      
        this._compteService.getCompteByRib(this._compteDestination.rib).subscribe(
          data => {
            //this._compteDestination = data*/
            console.log(this._compteDestination)

            this.newOperation.compteSource = this._compteSource
            this.newOperation.compteDestination = this._compteDestination;
            this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
            console.log("Succes Versement \n"+this.newOperation)
            this._operationService.virer(this.newOperation)
                .subscribe(
                  data =>  Swal.fire({
                  
                    title:"virement effectue par succes ",
                   
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
                    window.location.href = "/operations/virement";
                  })
                     })
      }
    

    
    
  
    
    
    
  

  init(){
    this._compteSource = new Compte()
    this._compteDestination = new Compte()
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Virement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant
    this.newOperation.compteSource = new Compte
    this.newOperation.compteDestination = new Compte()
  }

}