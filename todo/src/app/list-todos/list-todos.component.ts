import { Component, OnInit } from '@angular/core';
import { WelcomeComponent } from '../welcome/welcome.component';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

export class Todo {

  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) { }

}



@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[]
  message: string
  // todos = [
  //   new Todo(1, 'Learn to Dance', false, new Date()),
  //   new Todo(2, 'Become expert in Angular', false, new Date()),
  //   new Todo(3, 'Become java Expert', false, new Date())
  // ]


  constructor(
    private service: TodoDataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.refreshTodos();
  }

  deleteTodo(id) {
    console.log(`delete todo ${id}`)
    this.service.deleteTodo('akhilesh', id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of todo ${id} Successful!`
      }
    )
    this.refreshTodos();
  }

  updateTodo(id) {
    console.log(`updateTodo ${id}`)
    this.router.navigate(['todos', id])
  }

  addTodo() {
    this.router.navigate(['todos', -1])
  }



  refreshTodos() {
    this.service.retrieveAllTodos('akhilesh').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }
}
