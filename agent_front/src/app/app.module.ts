import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { ClientService } from './Service/client.service';
import { XhrInterceptor } from './Service/XhrInterceptor';

import { routingComponents } from './app-routing.module';
import { ListCompteComponent } from './list-compte/list-compte.component';
import { CompteDesactiveComponent } from './compte-desactive/compte-desactive.component';
import { LoginComponent } from './login/login.component';
import { CompteService } from './Service/compte.service';
import { OperationService } from './Service/operation.service';
import { LoginService } from './Service/login.service';
import { CookieService } from 'ngx-cookie-service';
import { ErrorHandlerService } from './Service/ErrorHandlerService';
import { LogoutComponent } from './logout/logout.component';



@NgModule({
  declarations: [
    AppComponent,
    NemuBarComponent,
    routingComponents,
    ListCompteComponent,
    CompteDesactiveComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [ClientService,CompteService,OperationService,LoginService, CookieService,
  {
  provide:ErrorHandler,
  useClass:ErrorHandlerService
  },
   { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
