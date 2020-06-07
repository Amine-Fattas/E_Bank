import { Component, OnInit } from '@angular/core';
import { Agent } from '../model/Agent';
import { AuthentificationService } from '../Service/authentification.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  _agent:Agent

  constructor(private _auth: AuthentificationService) { }

  ngOnInit(): void {
   
    this._auth.currentAgent().subscribe(
      data => {
        this._agent = data
        console.log(this._agent)
      },
      error => console.error(error)
    )
  }

}
