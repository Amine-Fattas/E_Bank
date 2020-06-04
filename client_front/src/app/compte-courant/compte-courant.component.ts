import { Component, OnInit } from '@angular/core';
import { CompteService } from '../Service/compte.service';
import { Compte } from '../model/Compte';
import { Client } from '../model/client';
import { Agent } from '../model/Agent';
import { error } from 'protractor';

@Component({
  selector: 'app-compte-courant',
  templateUrl: './compte-courant.component.html',
  styleUrls: ['./compte-courant.component.css']
})
export class CompteCourantComponent implements OnInit {

  constructor(private compteService: CompteService) { }

  compte: Compte

  ngOnInit(): void {
    // this.getTest();
    this.compte = new Compte()
    this.compte.client = new Client()
    this.compte.agent = new Agent()
    this.compteService.getCurrentCompte().subscribe(
      data => {
        this.compte = data
        console.log(this.compte)
      },
      error => console.error(error)
    )
  }
  // getTest(){
  //   this.compteService.test().subscribe(respo =>{
  //     console.log(respo);
  //   },error =>{
  //     console.log(error);
  //   })
  // }


}
