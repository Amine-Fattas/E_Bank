import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router';

import { Agent } from '../model/Agent';
import { AgentService } from '../Service/agent.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public credentials = {
    username: '',
    password: ''
  };

  agent:Agent;
  


  constructor(
    private loginService:LoginService,
   private agentService:AgentService,
    private router: Router) { }
    
  ngOnInit(): void {
      this.agentService.currentAgent.subscribe(
        agent => this.agent = agent
      )

    
  }

  login(){
    console.log("log-1");
    this.loginService.authenticate(this.credentials).subscribe(
     res=>{
      
      this.agentService.changeAgent(res); 
          
          // currentAgent = res;
        }
            
    );
    /*this.loginService.currentAgent.subscribe(mess=>
      {console.log("hello")});*/
    console.log("log-2");
    this.router.navigateByUrl('/acceuil');
  }
}

export var currentAgent: Agent


    /*console.log("login-1")
    this.loginService.authenticate(this.credentials).subscribe(
      res=>{console.log(res);
        this.agent=res;
      this.router.navigateByUrl('/acceuil');
      console.log("acceuil");}
      );*/


   /* this.loginService.authenticate(this.credentials,()=>{
      this.router.navigateByUrl('/acceuil');
      
    });*/
    

  

