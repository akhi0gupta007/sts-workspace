import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor {


  intercept(request: HttpRequest<any>, next: HttpHandler){    
    let basicAuthHeaderString = this.basicAuthService.getAuthenticatedToken();
    let username = this.basicAuthService.getAuthenticatedUser();

    if(basicAuthHeaderString && username){
      request = request.clone({
        setHeaders:{
          Authorization: basicAuthHeaderString
        }
      });
    }
    return next.handle(request);
  }

  constructor(private basicAuthService:BasicAuthenticationService) { }
}
