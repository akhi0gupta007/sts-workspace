import React, { Component } from 'react'
import TodoDataService from '../../api/todo/TodoDataService'
import AuthenticationService from './AuthenticationService'

class ListTodosComponent extends Component {

    constructor(props) {
        // console.log('constructor')
        super(props)
        this.state = {
            todos: [],
            message: null
        }

        this.deleteTodoClicked = this.deleteTodoClicked.bind(this)
        this.refreshTodo  = this.refreshTodo.bind(this)

    }
    //used when we want to free resource @override
    componentWillUnmount() {
        // console.log('componentWillUnmount ')
    }

    shouldComponentUpdate(nextProps, nextState) {
        // console.log('shouldComponentUpdate')
        // console.log(nextProps)
        // console.log(nextState)
        return true //if we return false, react does not render, see doc for more info
    }

    deleteTodoClicked(id) {
        let username = AuthenticationService.getLoggedInUser();
        // console.log("Delete clicked id" + id, " user " + username)
        TodoDataService.deleteTodo(username, id)
            .then(
                response => {
                    this.setState(
                        {
                            message: `Delete of todo ${id} is successful`
                        }                     
                    )
                    this.refreshTodo();
                }
            )
    }

    //Dont do API calls in constructor as it might take some time, once component is rendered we can call this method to load up the todos
    componentDidMount() {      
        console.log('componentDidMount ')
        this.refreshTodo()
    }

    refreshTodo(){
        TodoDataService.retrieveAllTodos()
        .then(
            response => {
                // console.log(response)
                this.setState(
                    {
                        todos: response.data
                    }
                )
            }
        )
    }


    render() {
        // console.log('render')
        return (
            <div>
                <h1>List Todos</h1>
                {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>IsCompleted?</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.todos.map(
                                    todo =>
                                        <tr key={todo.id}>
                                            <td>{todo.description}</td>
                                            <td>{todo.done.toString()}</td>
                                            <td>{todo.targetDate.toString()}</td>
                                            <td><button className="btn btn-danger" onClick={() => this.deleteTodoClicked(todo.id)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>

            </div>
        )
    }
}

export default ListTodosComponent;