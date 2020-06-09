import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { DatePipe } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 
import { MatCheckboxModule} from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { ClientService } from './Service/client.service';
import { XhrInterceptor } from './Service/XhrInterceptor';
import { MatStepperModule } from '@angular/material/stepper';
import { MatIconModule } from '@angular/material/icon';
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
import { AuthentificationService } from './Service/authentification.service';
import { MultiFormComponent } from './multi-form/multi-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RetraitComponent } from './retrait/retrait.component';
import { ProfileComponent } from './profile/profile.component';
import { DetailCompteComponent } from './detail-compte/detail-compte.component';







@NgModule({
  declarations: [
    AppComponent,
    NemuBarComponent,
    routingComponents,
    ListCompteComponent,
    CompteDesactiveComponent,
    LoginComponent,
    LogoutComponent,
    MultiFormComponent,
    RetraitComponent,
    ProfileComponent,
    DetailCompteComponent
  ],
  imports: [
    BrowserModule, AppRoutingModule,HttpClientModule,FormsModule,BrowserAnimationsModule ,MatStepperModule,
    MatIconModule,MatButtonModule,MatCheckboxModule,MatFormFieldModule,MatInputModule,ReactiveFormsModule
   
  ],
  providers: [ClientService,CompteService,DatePipe,OperationService,LoginService, CookieService,AuthentificationService,
  {
  provide:ErrorHandler,
  useClass:ErrorHandlerService
  },
   { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
