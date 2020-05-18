import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class XhrInterceptor implements HttpInterceptor{
  

  constructor(private cookieService: CookieService){}

  intercept(req: HttpRequest<any>, next: HttpHandler){

    
  console.log("inter-1")
    const token = this.cookieService.get('token');
     console.log(`${token}`)

   /* const xhr = req.clone({
      headers: req.headers.set('Authorization ', `Basic ${token}`)
    });
    */
    const xhr=req.clone({ setHeaders: { Authorization: `Basic ${token}` } });

    return next.handle(xhr);
  
  }

}
