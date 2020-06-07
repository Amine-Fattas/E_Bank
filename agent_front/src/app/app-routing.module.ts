import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { EditClientComponent } from './edit-client/edit-client.component';


import { DetailClientComponent } from './detail-client/detail-client.component';
import { OperationsComponent } from './operations/operations.component';
import { VirementComponent } from './virement/virement.component';
import { VersementComponent } from './versement/versement.component';

import { ListCompteComponent } from './list-compte/list-compte.component';
import { CompteDesactiveComponent } from './compte-desactive/compte-desactive.component';
import { NemuBarComponent } from './nemu-bar/nemu-bar.component';
import { LoginComponent } from './login/login.component';
import { MultiFormComponent } from './multi-form/multi-form.component';
import { RetraitComponent } from './retrait/retrait.component';
import { ProfileComponent } from './profile/profile.component';





const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // empty path bach t gerer empty root link yak?
  { path: 'login',component:LoginComponent},// eventuellement anbiw ngeriw l'error  hafnld te7t  // '**' hadi pour gerer les erreur
  //{ path: '**', component: LoginComponent},// ** pour gerer les erreur de login err
  {path:"listClient",component:ClientComponent},
  {path:"detailsClient/:id",component:DetailClientComponent},// Oki, s
  // {path:"contacts",component:ContactsComponent},
  // {path:"new-contact",component: NouveauContactComponent},
  { path: "editClient/:id", component: EditClientComponent},
  { path: "acceuil", component:ProfileComponent},
  {path:"comptes",
        children:[
          {path:"ajoutCompte",component:MultiFormComponent},
          {path:"listCompte",component:ListCompteComponent},
          {path:"compteDesactive",component:CompteDesactiveComponent}
        ]},
  { path: "operations", 
      children: [
        { path: "", redirectTo: "/operations/liste", pathMatch: "full"},
        { path: "liste", component: OperationsComponent},
        { path: "retrait", component: RetraitComponent},
        { path: "virement", component: VirementComponent},
        { path: "versement", component: VersementComponent}
      ]
} // { path: '**'} ici gere tous les components avant


  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ClientComponent,
                                  EditClientComponent,
                                  OperationsComponent,
                                  VirementComponent,
                                  VersementComponent,
                                  DetailClientComponent,
                                  RetraitComponent
                                ]
