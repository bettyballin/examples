import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyService {

  private token = 'your-auth-token';

  constructor(private http: HttpClient) { }

  fetchData() {
    return this.http.get(`https://myappname.firebaseio.com/data.json?auth=${this.token}`).toPromise();
  }

}