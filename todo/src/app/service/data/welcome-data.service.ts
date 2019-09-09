import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http: HttpClient
  ) { }

  executeHelloWorldBeanService() {   
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
  }

  executeHelloWorldBeanServiceWithPathVariable(name) {   
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world/path-variable/${name}`);
  }

  createBasicAuthenticationHttpHeader(){
    let username = 'akhilesh'
    let password = 'dummy'
    let basicAuthHeaderString = 'Basic '+ window.btoa(username + ':'+password);
    return basicAuthHeaderString;
  }
}

 

export class HelloWorldBean{
  constructor(public message:string){

  }
}
