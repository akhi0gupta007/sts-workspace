import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }
  userName:string

  authenticate(username, password) {
    // console.log('Before '+this.isUserLoggedIn())
    if (username === 'akhilesh' && password === 'dummy') {
      sessionStorage.setItem('authenticatedUser',username);
      // console.log('After '+this.isUserLoggedIn())
      return true;
    } else {
      return false;
    }
    
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticatedUser')
    this.userName = user
    return !(user == null)
  }

  logout(){
    sessionStorage.removeItem('authenticatedUser');
  }

  getUserName(){
    return this.userName;
  }
}
