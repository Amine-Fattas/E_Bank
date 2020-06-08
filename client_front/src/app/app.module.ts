import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 
import { XhrInterceptor } from './Service/xhr-interceptor';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { ClientService } from './Service/client.service';
import { ErrorHandlerService } from './Service/error-handler.service';
import { routingComponents } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { CompteService } from './Service/compte.service';
import { OperationService } from './Service/operation.service';
import {AuthentificationService} from './Service/authentification.service';






@NgModule({
  declarations: [
    AppComponent,
    NemuBarComponent,
    routingComponents,
    LoginComponent,
    AcceuilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [ClientService,CompteService,OperationService,AuthentificationService,
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true},  {
      provide:ErrorHandler,
      useClass:ErrorHandlerService
      }],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
