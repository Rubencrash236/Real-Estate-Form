import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Form } from 'src/app/models/form';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private urlEndPoint: string = "http://localhost:7000/submit";
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  postForm(form:any): Observable<Form>{
    return this.http.post<Form>(this.urlEndPoint,form).pipe(
      catchError(e => {
        return throwError(e);
      })
    );
  }

  getStates(): Observable<any>{
    return this.http.get<any>('https://parseapi.back4app.com/classes/Usabystate_States?order=name&keys=name,postalAbreviation',{headers: {
        'X-Parse-Application-Id': '5oV9JuNSnIdCqJZx5jXw7Y9wcLmbLZOA2vbYhH1j', // This is your app's application id
        'X-Parse-REST-API-Key': '8jJ57AsseZ3icESR0ds9QuZxqY2WXkWe2QWh9LKB', // This is your app's REST API key
      }
    }).pipe(
      catchError(e => {
        return throwError(e);
      })
    );
  }

  getCitiesFromState(state: string): Observable<any>{
    return this.http.get(`https://parseapi.back4app.com/classes/Usabystate_${state}?limit=600&order=name&keys=name`,{headers: {
      'X-Parse-Application-Id': '5oV9JuNSnIdCqJZx5jXw7Y9wcLmbLZOA2vbYhH1j', // This is your app's application id
      'X-Parse-REST-API-Key': '8jJ57AsseZ3icESR0ds9QuZxqY2WXkWe2QWh9LKB', // This is your app's REST API key
      }
    }).pipe(
      catchError(e => {
        return throwError(e);
      })
    );
  }

  getCountries(): Observable<any>{
    return this.http.get('https://restcountries.eu/rest/v2/all?fields=name');
  }
}
