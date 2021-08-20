import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './components/form/form.component';
import { SuccessComponent } from './components/success/success.component';


const routes: Routes = [
  {path: 'form', component: FormComponent},
  {path: 'success', component: SuccessComponent},
  {path: '**', component: FormComponent},
  /*{path: '/', redirectTo: 'form',pathMatch: 'full'},*/
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
