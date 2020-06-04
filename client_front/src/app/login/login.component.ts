import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../Service/authentification.service';
import { Router } from '@angular/router';
import { ClientService } from '../Service/client.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService:AuthentificationService,private router: Router,private clientService:ClientService) { }

  public credentials = {
    username: '',
    password: ''
  };

  ngOnInit(): void {
  }

  onLogin(user) {
    this.authService.login(user)
   .subscribe(resp=>{
     let jwt = resp.headers.get('authorization');
     this.authService.saveToken(jwt);
     this.router.navigateByUrl('/acceuil');
     this.authService.currentClient().subscribe(resp => {this.clientService.changeClient(resp);
      console.log(resp);})
    
   }
     ),
     err => {this.router.navigateByUrl('/login');}
 }
}


