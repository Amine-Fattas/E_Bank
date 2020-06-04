import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router';

import { Agent } from '../model/Agent';
import { AgentService } from '../Service/agent.service';
import { AuthentificationService } from '../Service/authentification.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mode: number;

  public credentials = {
    username: '',
    password: ''
  };

  agent: Agent;
  


  constructor(
    private loginService:LoginService,
   private agentService:AgentService,
   private authService:AuthentificationService,
    private router: Router) { }
      ngOnInit(): void {
      this.agentService.currentAgent.subscribe(
        agent => this.agent = agent
      )
  }

 /* login(){

    this.loginService.authenticate(this.credentials).subscribe(
     res=>{
      console.log(res);
      this.agentService.changeAgent(res); 
          
          // currentAgent = res;
        }
            
    );
    
  
    this.router.navigateByUrl('/acceuil');

}}

export var currentAgent: Agent*/


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
    onLogin(user) {
      console.log("user1")
       this.authService.login(user)
      .subscribe(resp=>{
        console.log("user2")
        console.log(resp.headers)
        let jwt = resp.headers.get('authorization');
        this.authService.saveToken(jwt);
        this.router.navigateByUrl('/acceuil');
       this.authService.currentAgent().subscribe(resp => {this.agentService.changeAgent(resp);
        console.log(resp);})
      }
        ),
        err => {this.router.navigateByUrl('/login');}
    }
  }
  export var currentAgent: Agent;
  

