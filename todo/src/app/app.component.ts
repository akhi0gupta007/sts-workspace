import { Component } from '@angular/core';

@Component({ //Decorator similar to annotation in java
  selector: 'app-root', //Tag name of a component
  templateUrl: './app.component.html', //we can also hard code HTML using template property
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todo';
  message= 'Welcome to Jungle';
}
