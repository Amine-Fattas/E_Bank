import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OperationsComponent } from './operations/operations.component';
import { VirementComponent } from './virement/virement.component';


import { RechargeComponent } from './recharge/recharge.component';
import { CompteCourantComponent } from './compte-courant/compte-courant.component';

import { LoginComponent } from './login/login.component';
import { AcceuilComponent } from './acceuil/acceuil.component';




const routes: Routes = [

  { path: '', redirectTo: '/login', pathMatch: 'full' }, 
  { path: 'login',component:LoginComponent},
  { path: "acceuil", component:AcceuilComponent},
  { path: "compte", 
      children: [
        { path: "", redirectTo: "/compte/courant", pathMatch: "full"},
        { path: "courant", component: CompteCourantComponent}
       
      ] 
  },
  { path: "operations", 
      children: [
        { path: "", redirectTo: "/operations/liste", pathMatch: "full"},
        { path: "liste", component: OperationsComponent},
        { path: "recharge", component: RechargeComponent},
        { path: "virement", redirectTo: "/operations/virement/externe", pathMatch: "full"},
        { path: "virement/externe", component: VirementComponent}
        
      ]
  }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [CompteCourantComponent,
                                 
                                  OperationsComponent,
                                  RechargeComponent,
                                  VirementComponent
                                 ]
