import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders ,HttpErrorResponse} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class PhoneBookService {

  private _httpOptions: any;
  private _numbersListAPIURL = 'http://localhost:8080/api/v1/numbers?';
 
  
  constructor(public http: HttpClient) {
    this.init();
   }
  
  
  public init(){
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    this._httpOptions = {
        observe: 'response' as 'response'
    };
   }

   public viewAllNumbers(pageNumber,filterModel):Observable<any>{
    let url = this._numbersListAPIURL+"pageNumber="+pageNumber+"&phoneNumber="+filterModel;
    return this.http.get<any>( url, this._httpOptions)
  
   }


}
