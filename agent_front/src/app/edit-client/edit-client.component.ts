import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client'
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../Service/client.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {
 public client: Client = new Client();
 public idClient: number;
 constructor(public activatedRoute: ActivatedRoute, public serviceClient: ClientService,
  public router: Router) {
   this.idClient = activatedRoute.snapshot.params['id'];
 }

  ngOnInit(): void {
    this.serviceClient.getClient(this.idClient)
    .subscribe(data => {
     this.client = data },
    erreur => console.log(erreur)
    )
  }
  numericOnly(event): boolean { // restrict e,+,-,E characters in  input type number
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode === 101 || charCode === 69 || charCode === 45 || charCode === 43) {
      return false;
    }
    return true;

  }

    updateClient() {
      console.log('edit');
      this.serviceClient.updateClient(this.client)
      .subscribe(data => {Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Modification enregitré',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigate(['listClient']);
    },
      erreur => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
         });
      });
  }
}
