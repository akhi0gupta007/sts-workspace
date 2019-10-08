import React, { Component } from 'react'
import TodoDataService from '../../api/todo/TodoDataService'
import AuthenticationService from './AuthenticationService'

class ListTodosComponent extends Component {

    constructor(props) {
        console.log('constructor')
        super(props)
        this.state = {
            todos: [
                // { id: 1, description: 'Learn React', done: false, targetDate: new Date() },
                // { id: 2, description: 'Visit Spit in Himachal', done: false, targetDate: new Date() },
                // { id: 3, description: 'Learn Java 8', done: false, targetDate: new Date() }
            ]
        }

    }
    //used when we want to free resource @override
    componentWillUnmount(){
        console.log('componentWillUnmount ')
    }

    shouldComponentUpdate(nextProps,nextState){
        console.log('shouldComponentUpdate')
        console.log(nextProps)
        console.log(nextState) 
        return true
    }

    //Dont do API calls in constructor as it might take some time, once component is rendered we can call this method to load up the todos
    componentDidMount(){
        let username = AuthenticationService.getLoggedInUser()
        console.log('componentDidMount '+username)
        TodoDataService.retrieveAllTodos()
        .then(
            response => {
                console.log(response)
                this.setState(
                    {
                       todos : response.data 
                    }
                )
            }
        )
    }


    render() {
        console.log('render')
        return (
            <div>
                <h1>List Todos</h1>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>IsCompleted?</th>
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