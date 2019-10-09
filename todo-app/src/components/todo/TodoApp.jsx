import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import AuthenticatedRoute from './AuthenticatedRoute'
import LoginComponent from './LoginComponent'
import ListTodosComponent from './ListTodosComponent'
import WelcomeComponent from './WelcomeComponent'
import LogoutComponent from './LogoutComponent'
import FooterComponent from './FooterComponent'
import ErrorComponent from './ErrorComponent'
import TodoComponent from './TodoComponent'

class TodoApp extends Component {

    render() {
        return (
            <div className="TodoApp">
                <Router>
                    <>
                        <HeaderComponent></HeaderComponent>
                        <Switch>
                            <Route path="/" exact component={LoginComponent}></Route>
                            <Route path="/login" component={LoginComponent}></Route>
                            <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}></AuthenticatedRoute>
                            <AuthenticatedRoute path="/todos/:id" component={TodoComponent}></AuthenticatedRoute>
                            <AuthenticatedRoute path="/todos" component={ListTodosComponent}></AuthenticatedRoute>                           
                            <AuthenticatedRoute path="/logout" component={LogoutComponent}></AuthenticatedRoute>
                            <Route path="" component={ErrorComponent}></Route>
                        </Switch>
                        <FooterComponent></FooterComponent>
                    </>
                </Router>
                {/* <LoginComponent /> */}
            </div>
        )
    }
}


export default TodoApp;