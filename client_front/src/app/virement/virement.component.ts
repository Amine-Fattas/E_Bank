import { Component, OnInit } from '@angular/core';
import { OperationService } from '../Service/operation.service';
import { Operation } from '../model/operation';
import { Compte } from '../model/Compte';
import { CompteService } from '../Service/compte.service';
import { AuthentificationService } from '../Service/authentification.service';
import { Client } from '../model/client';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {

  newOperation: Operation
  compte: Compte
  _compteDestination: Compte
  client: Client

  constructor(private _operationService: OperationService,
              private _compteService: CompteService,
              private _authentificationService: AuthentificationService) { }

  ngOnInit(): void {
    this._authentificationService.currentClient().subscribe(
      client => {
        this.client = client;
        console.log(client);
        this._compteService.getCompteByIdClient(this.client.id).subscribe(
          data => {
            this.compte = data
            console.log(this.compte)
            this.compte.client = this.client
          },
          error => console.error(error)
        )
      }
    )
    this.init()
  }

  onSubmit(){
    this.newOperation.compteSource = this.compte
    this.newOperation.agent = null
    this.newOperation.numOperation = Math.floor(Math.random() * 1000000)
    console.log("Succes Virement \n"+this.newOperation)
    this._operationService.virer(this.newOperation)
              .subscribe(
                data => Swal.fire(
                 
                  'Virement  effectué par succes' ,
                  'success'
                  
                ).then(function(){
                  window.location.href = "/acceuil"})
                   , err => { Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: 'Compte n existe pas ou désactivé!'
                }).then(function(){
                  window.location.href = "/operations/virement/externe";
                })
                   })}
    // this._compteService.getCompteByRib(this.newOperation.compteDestination.rib).subscribe(
    //   data => {
    //     this._compteDestination = data;
    //     this.newOperation.compteDestination = this._compteDestination
        
    //   }
    // )
  

  init(){
    this.newOperation = new Operation()
    this.newOperation.typeOperation = "Virement"
    this.newOperation.numOperation = 0
    this.newOperation.dateOperation = new Date()
    this.newOperation.montant = 0
    this.newOperation.compteSource = new Compte()
    this.newOperation.compteDestination = new Compte()
  }
}
