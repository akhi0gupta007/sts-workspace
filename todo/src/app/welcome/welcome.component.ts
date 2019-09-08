import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
//by using export keyword this class can be used outside of this file ( or the module)
export class WelcomeComponent implements OnInit {
 
  message = 'Some welcome message'
  param = ''
  welcomeMessageService:string
  errorMessage:string
  //keyword constructor used to define constructor
  //We are using ActivateRoute
  constructor(private route: ActivatedRoute, private service:WelcomeDataService) {

  }

  //quite similar to void ngOnInit()
  ngOnInit() {    
    this.param = this.route.snapshot.params['name']
  }

  getWelcomeMessage(){
    console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error=>this.handleErrorResponse(error)
    );

    console.log('getWelcome() ends')
    
  }

  getWelcomeMessageWithParam(){
    
    this.service.executeHelloWorldBeanServiceWithPathVariable(this.param).subscribe(
      response => this.handleSuccessfulResponse(response),
      error=>this.handleErrorResponse(error)
    );

    console.log('getWelcome() ends')
    
  }


  handleSuccessfulResponse(response){
    this.welcomeMessageService = response.message;
    this.errorMessage='';
  }

  handleErrorResponse(error){
    this.errorMessage = error.error.message;
  }

}
//In javascript one module represent one file, and one file contains multiple functions and classes