import { Component, OnInit } from '@angular/core';
import { Form } from 'src/app/models/form';
import { States } from 'src/app/models/states';
import { FormService } from './form.service';
import { statesApi } from 'src/app/models/statesApi';


@Component({
  selector:'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private formService: FormService) { }
  
  comunities: string[] = ['Abierta', 'Cerrada', 'Comercial'];
  countries: any = [];
  states: States[] = [];
  form: Form = new Form();
  today: Date = new Date;
  cities: string[] = [];
  stateData: statesApi[] = [];

  ngOnInit(): void {
    this.today = new Date();
    this.form = new Form();
    
    this.formService.getStates().subscribe(res =>{
      res.results.forEach((element: any) => {
        let aux: statesApi = new statesApi(element.name, element.postalAbreviation);
        this.stateData.push(aux);
      });
    })

    this.formService.getCountries().subscribe(res => {
      res.forEach((element: any) => {
        this.countries.push(element.name);
      });
    })
  }

  getState(state: statesApi){
    if(this.form.state){
      this.cities = [];
      this.formService.getCitiesFromState(state.abbr).subscribe(res =>{
        res.results.forEach((element: any) => {
          this.cities.push(element.name);
        });;
      })
    } 
   }
 
   send(){
     let date = new Date();
     this.form.pdfName = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}_${this.form.name}_${this.form.surname}`;
     this.formService.postForm(this.form).subscribe(res => {
       //redirect to success with the response status
       console.log()
     }, error =>{
       console.log(error.status);
     });
   }
 
   isGoodToGo(): boolean{
     if(this.form.financeType==""){
       return false;
     }else if(this.form.propertyType==""){
       return false;
     }else if(this.form.floors==""){
       return false;
     }
     
     return true;
   }
   //($event.target as HTMLInputElement)
   chooseConstructionState(ev: any): void {
    this.form.constructionState = (ev as HTMLInputElement).value;
    let year = <HTMLInputElement>document.getElementById("year");
    
    if(this.form.constructionState == 'Nueva'){  
      year.disabled = true;
      year.value = this.today.getFullYear().toString();
      
    }else{

      year.disabled = false;
    }
    this.form.minConstructionYear = year.value;
   }

   choosePropertyType(ev: any): void{
     this.form.propertyType = (ev as HTMLInputElement).value;
   }

   chooseFloorQuant(ev: any): void {
     this.form.floors = (ev as HTMLInputElement).value;
   }

   chooseFinanceType(ev: any): void {
     this.form.financeType = (ev as HTMLInputElement).value;
   }

   isResidence(ev: any): void {
     this.form.residence = (ev as HTMLInputElement).checked;
   }

   isVisa(ev: any): void {
     this.form.visa = (ev as HTMLInputElement).checked;
   }
}
