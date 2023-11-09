import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginCreds } from './profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService implements OnInit {

  private baseUrl = 'http://localhost:8888/api/profile';
  // private baseUrl = 'https://task-supervision-app.onrender.com/api/tasks';


  constructor(private http : HttpClient) { }



  loginUser(loginCreds:LoginCreds) : Observable<any> {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    const loginData = {
      username:loginCreds.username,
      password:loginCreds.password
    }

    return this.http.post<any>(this.baseUrl+"/postSignIn" , loginData,httpOptions);

  }



  ngOnInit(): void {
  }


}
