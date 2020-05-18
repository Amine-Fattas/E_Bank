import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OperationsComponent } from './operations/operations.component';
import { VirementComponent } from './virement/virement.component';
import { ContactComponent } from './contact/contact.component';
import { VirementInterneComponent } from './virement-interne/virement-interne.component';
import { RechargeComponent } from './recharge/recharge.component';
import { CompteCourantComponent } from './compte-courant/compte-courant.component';
import { CompteEpargneComponent } from './compte-epargne/compte-epargne.component';




const routes: Routes = [
  { path: "", redirectTo: "/compte/courant", pathMatch: "full"},
  { path: "compte", 
      children: [
        { path: "", redirectTo: "/compte/courant", pathMatch: "full"},
        { path: "courant", component: CompteCourantComponent},
        { path: "epargne", component: CompteEpargneComponent}
      ] 
  },
  { path: "operations", 
      children: [
        { path: "", redirectTo: "/operations/liste", pathMatch: "full"},
        { path: "liste", component: OperationsComponent},
        { path: "recharge", component: RechargeComponent},
        { path: "virement", redirectTo: "/operations/virement/externe", pathMatch: "full"},
        { path: "virement/externe", component: VirementComponent},
        { path: "virement/interne", component: VirementInterneComponent}
        
      ]
  },
  {path:"contact", component: ContactComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [CompteCourantComponent,
                                  CompteEpargneComponent,
                                  OperationsComponent,
                                  RechargeComponent,
                                  VirementComponent,
                                  VirementInterneComponent,
                                  ContactComponent]
