import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {
  constructor(
    private http: HttpClient
  ) { }

  userName: string


  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    let headers = new HttpHeaders(
      {
        Authorization: basicAuthHeaderString
      }
    )
    return this.http.get<AuthenticationBean>(`http://localhost:8080/basicauth`, { headers }).pipe(
      map(
        data => {
          sessionStorage.setItem('authenticatedUser', username);
          sessionStorage.setItem('token', basicAuthHeaderString);
          return data;
        }
      )
    );
  }

  getAuthenticatedUser(){
    return sessionStorage.getItem('authenticatedUser');
  }

  getAuthenticatedToken(){
    if(this.getAuthenticatedUser())
    return sessionStorage.getItem('token');
  }

  
  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser')
    this.userName = user
    return !(user == null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser');
    sessionStorage.removeItem('token');
  }

  getUserName() {
    return this.userName;
  }
}



export class AuthenticationBean {
  constructor(public message: string) { }
}