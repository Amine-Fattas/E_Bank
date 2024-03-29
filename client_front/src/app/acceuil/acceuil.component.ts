import { Component, OnInit } from '@angular/core';
import { Compte } from '../model/Compte';
import { Client } from '../model/client';
import { AuthentificationService } from '../Service/authentification.service';
import { CompteService } from '../Service/compte.service';
import { Agent } from '../model/Agent';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.css']
})
export class AcceuilComponent implements OnInit {
  compte: Compte
  client: Client
  constructor(private _compteService: CompteService,
    private _authentificationService: AuthentificationService) { }

  ngOnInit(): void {
    this.compte = new Compte()
    this.compte.client = new Client()
    this.compte.agent = new Agent()
    this._authentificationService.currentClient().subscribe(
      client => {
        
        this.client = client;
        console.log(client);
        this._compteService.getCompteByIdClient(this.client.id).subscribe(
          data => {
            
            this.compte = data
            if(this.compte.etat==false){
              Swal.fire({
                icon: 'error',
                title: 'Oops...',
                confirmButtonColor: 'black',
                text: 'Votre compte est désactivé  !'
              }).then(function(){
                window.location.href = "/login";
              })
          }
          
            this.compte.client = this.client
            console.log("-------------------------------------")
            console.log(this.client)
            
          },
          error => console.error(error)
        )
      }
    )
  }

}
