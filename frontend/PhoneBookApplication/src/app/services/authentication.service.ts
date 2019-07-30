import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { catchError } from 'rxjs/operators';
const CLIENT_SECRET = 'password';
const CLEINT_ID = 'PhoneRegistery';

 
@Injectable()
export class AuthenticationService {
    private apiUrl : string = "/oauth/token";
    private  host: string = 'http://localhost:8080';
    constructor(private http: HttpClient) {
     }
 

    getToken(){
        return localStorage.getItem('token');
    }

    
    login(username: string, password: string) :Observable<any>{
          var basicheader = btoa(CLEINT_ID + ':' + CLIENT_SECRET);
          var headers = new HttpHeaders();
          headers = headers.append('Authorization', 'Basic ' + basicheader);
          headers = headers.append('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
       
          const httpOptions = {
            headers:headers,
            observe: 'response' as 'response'
          };
           var requestBody = 'username=' + username + '&password=' + password + '&grant_type=' + 'password';
         
       return this.http.post<any>(this.host  + this.apiUrl,requestBody, httpOptions)
       .pipe(   catchError(err => {
        const error = err.error.message || err.statusText;
        return throwError(error)}))
     
    }
 

   
    private handelError(errorResponse:HttpErrorResponse){
      if (errorResponse.error instanceof ErrorEvent){
        console.error('Client Side Error :',errorResponse.error.message)
      }else{
        console.error('Server Side Error :',errorResponse)
      }
      return throwError('There is a problem with the service. We are notified & working on it .Please try again later');
    }
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('token');
    }
}