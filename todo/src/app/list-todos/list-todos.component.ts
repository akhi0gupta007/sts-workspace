import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos = [
    { id: 1, description: "Learn to Dance" },
    { id: 2, description: "Become expert in Angular" },
    { id: 3, description: "Become java Expert" }
  ]


  constructor() { }

  ngOnInit() {
  }

}
