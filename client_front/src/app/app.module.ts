import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 
import { XhrInterceptor } from './Service/xhr-interceptor';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { ClientService } from './Service/client.service';

import { routingComponents } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { AcceuilComponent } from './acceuil/acceuil.component';






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
  providers: [ClientService,
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
