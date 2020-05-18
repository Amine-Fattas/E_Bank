import { Injectable, ErrorHandler } from "@angular/core";
import { HttpErrorResponse } from '@angular/common/http';
import Swal from 'sweetalert2';

@Injectable()
export class ErrorHandlerService implements ErrorHandler{

    handleError(error:any):void{
      if(error instanceof HttpErrorResponse){
          if(error.status===401){
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Login ou usurname incorecte!',
                 // mzl mabanch lia imta kaymchi lroutage
                // fchkl katmchi dghia ms hia kayna hadi
              })  
              window.location.assign('');  
          }
          else{
              window.alert(error.message);
              
          }
        }
    else{
        console.log(error);
    }
      }
    }
    
