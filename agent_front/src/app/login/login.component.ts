import { Component, OnInit } from '@angular/core';
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
    
   private agentService:AgentService,
   private authService:AuthentificationService,
    private router: Router) { }
      ngOnInit(): void {
      this.agentService.currentAgent.subscribe(
        agent => this.agent = agent
      )
  }



    onLogin(user) {
   
 
       this.authService.login(user)
      .subscribe(resp=>{
       
       
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
  

