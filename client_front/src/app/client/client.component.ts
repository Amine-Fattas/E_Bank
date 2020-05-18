import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClientService } from '../Service/client.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
 public motCle:string;
 pageClient:any=[];
 idClient:number;
 constructor(public http:HttpClient,public clientService:ClientService,
  public router:Router) { }
  

  ngOnInit(): void {
    this.doSearch();
  }
  onEditContact(id:number){

   this.router.navigate(['editClient',id]);
  
 }
  doSearch(){
    this.clientService.getClients()
    .subscribe((data:any)=>{
      this.pageClient=data;
      console.log(data);
      },(error)=>console.log(error));

  }
  

}
