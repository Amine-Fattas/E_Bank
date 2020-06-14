import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nemu-bar',
  templateUrl: './nemu-bar.component.html',
  styleUrls: ['./nemu-bar.component.css']
})
export class NemuBarComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }
  logout(){
    Swal.fire({
      title: 'Vous etes vraiment  se déconnecter ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Non',
      confirmButtonText: 'Oui !'
    }).then((result) => {
      if (result.value) {  
        localStorage.removeItem('token');
        this.route.navigateByUrl('/login');
      }
        err=>{ Swal.fire(
          'Erreur ...')}
      
    })
  }
  onAcceuil(){
    window.location.href="/profile";
  }

    
  }

