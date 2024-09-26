import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  fetchData(idToken: string): Promise<any> {
    return this.http.get(`https://myappname.firebaseio.com/data.json?auth=${idToken}`).toPromise();
  }

}