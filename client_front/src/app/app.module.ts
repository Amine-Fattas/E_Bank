import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { ClientService } from './Service/client.service';

import { routingComponents } from './app-routing.module';




@NgModule({
  declarations: [
    AppComponent,
    NemuBarComponent,
    routingComponents
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
