import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
//by using export keyword this class can be used outside of this file ( or the module)
export class WelcomeComponent implements OnInit {

  message = 'Some welcome message'
  param = ''
  //keyword constructor used to define constructor
  //We are using ActivateRoute
  constructor(private route: ActivatedRoute) {

  }

  //quite similar to void ngOnInit()
  ngOnInit() {
    console.log(this.message)
    this.param = this.route.snapshot.params['name']
  }

}
//In javascript one module represent one file, and one file contains multiple functions and classes