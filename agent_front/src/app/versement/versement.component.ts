import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-versement',
  templateUrl: './versement.component.html',
  styleUrls: ['./versement.component.css']
})
export class VersementComponent implements OnInit {

  compteId:string
  montant:number

  constructor() { }

  ngOnInit(): void {
    
  }

}
