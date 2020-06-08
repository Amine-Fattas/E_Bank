import { Component, OnInit } from '@angular/core';
import { Compte } from '../model/Compte';
import { Client } from '../model/client';
import { AuthentificationService } from '../Service/authentification.service';
import { CompteService } from '../Service/compte.service';
import { Agent } from '../model/Agent';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nemu-bar',
  templateUrl: './nemu-bar.component.html',
  styleUrls: ['./nemu-bar.component.css']
})
export class NemuBarComponent implements OnInit {
  compte: Compte
  client: Client
  constructor(private _compteService: CompteService,private route:Router,
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
            console.log(this.compte)
            this.compte.client = this.client
          },
          error => console.error(error)
        )
      }
    )
  }
  logout(){
    console.log("logout")
    Swal.fire({
      title: 'Vous voulez vraiment se déconnecter ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Non',
      confirmButtonText: 'Oui !'
    }).then((result) => {
      if (result.value) {  
        localStorage.removeItem('token');
        this.route.navigateByUrl('/login');
      }
        err=>{ Swal.fire(
          'Erreur ...')}
      
    })
   
  }


}
