import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  public motif:string;
  pageOperation:any=[];
  numOperation:number;

  constructor() { }

  ngOnInit(): void {
    this.pageOperation = [
      {"numOperation": 0, "type": "Retrait", "date": "11/11/2020", "acteur": "Agent","source": "CL1", "destination": "CL2", "montant": 200}
    ]
  }

}
