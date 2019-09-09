import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'akhilesh'
  password = 'password'
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  //Form of dependecy injection, buildin Angular
  constructor(private router: Router,
    private hardCodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit() {
  }

  handleLogin() {
    console.log(this.username)
    if (this.hardCodedAuthenticationService.authenticate(this.username, this.password)) {
      this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }


  }

  handleBasicAuthLogin() {
    console.log(this.username)
    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['welcome', this.username])
          this.invalidLogin = false;
        },
        error => {
          console.log(error);
          this.invalidLogin = true
        }
      );
  }

}
