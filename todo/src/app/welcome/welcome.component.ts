import { Component, OnInit } from '@angular/core';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
//by using export keyword this class can be used outside of this file ( or the module)
export class WelcomeComponent implements OnInit {

  message = 'Some welcome message'
  //keyword constructor used to define constructor
  constructor() { }

  //quite similar to void ngOnInit()
  ngOnInit() {
    console.log(this.message)
  }

}
//In javascript one module represent one file, and one file contains multiple functions and classes