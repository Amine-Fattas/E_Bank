import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class XhrInterceptorService implements HttpInterceptor{
  private jwtToken:string;

  constructor(){}

  intercept(req: HttpRequest<any>, next: HttpHandler){
     console.log(req.url.indexOf('http://localhost:8082/login') )
    if (req.url.indexOf('http://localhost:8082/login') === 0) {
      console.log("do nothing")
      return next.handle(req);
    }
  else{

  console.log("inter-1")
  
    this.jwtToken=localStorage.getItem('token');
     console.log(this.jwtToken);

 
    const xhr=req.clone({ setHeaders: { Authorization: ` ${this.jwtToken}` } });

    return next.handle(xhr);
  }
  }

  
}
