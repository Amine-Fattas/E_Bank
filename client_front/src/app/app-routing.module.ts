import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { EditClientComponent } from './edit-client/edit-client.component';
import { OperationsComponent } from './operations/operations.component';
import { VirementComponent } from './virement/virement.component';
import { VersementComponent } from './versement/versement.component';
import { RetraitComponent } from './retrait/retrait.component';




const routes: Routes = [
  { path: "listClient", component: ClientComponent},
  /*{path:"contacts",component:ContactsComponent},
  {path:"new-contact",component: NouveauContactComponent},*/
  { path: "editClient/:id", component: EditClientComponent},
  { path: "operations", 
      children: [
        { path: "", redirectTo: "/operations/liste", pathMatch: "full"},
        { path: "liste", component: OperationsComponent},
        { path: "virement", component: VirementComponent},
        { path: "versement", component: VersementComponent},
        { path: "retrait", component : RetraitComponent}
      ]
}
  
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
                                  RetraitComponent]
