import { Component, OnInit } from '@angular/core';

import { LoginService } from '../Service/login.service';
import { LogoutService } from '../Service/logout.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private logoutService:LogoutService) { }

  ngOnInit(): void {
  }
  logout(){
    console.log("logouuuuuuut");
    this.logoutService.logout().subscribe(res=> console.log(res));
  }

}
