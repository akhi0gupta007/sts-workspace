import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import AuthenticationService from './AuthenticationService.js'
import HeaderComponent from './HeaderComponent'
import AuthenticatedRoute from './AuthenticatedRoute'
import { extname } from 'path'

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



class FooterComponent extends Component {
    render() {
        return (
            <footer className="footer">
                <span className="text-muted">All right Reserved @akhilesh</span>
            </footer>
        )
    }
}


class LogoutComponent extends Component {
    render() {
        return (
            <>
                <h1>You are logged out!</h1>
                <div className="container">
                    Thanks for visiting us.
                 </div>
            </>
        )
    }
}

class WelcomeComponent extends Component {
    render() {
        return (
            <>
                <h1>Welcome!</h1>
                <div className="container">

                    Welcome {this.props.match.params.name}. You can manage todos <Link to="/todos">here</Link>.
                {/* To avoid entire page refresh we are using Link tag */}

                </div>
            </>
        )
    }
}

class ListTodosComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            todos: [
                { id: 1, description: 'Learn React', done: false, targetDate: new Date() },
                { id: 2, description: 'Visit Spit in Himachal', done: false, targetDate: new Date() },
                { id: 3, description: 'Learn Java 8', done: false, targetDate: new Date() }
            ]
        }

    }

    render() {
        return (
            <div>
                <h1>List Todos</h1>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>Is Completed?</th>
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

function ErrorComponent() {
    return <div>An Error Occured!</div>
}

class LoginComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            username: 'akhilesh',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        // this.handleUserNameChange = this.handleUserNameChange.bind(this);
        // this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.loginClicked = this.loginClicked.bind(this);
    }


    handleChange(event) {
        //console.log('change event '+event.target.value);
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                    {/*  <ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}></ShowInvalidCredentials> */}
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credntials</div>}
                    {this.state.showSuccessMessage && <div>Login Successful</div>}
                    {/* optimised functional component
               <ShowLoginSucessMessage showSuccessMessage={this.state.showSuccessMessage}></ShowLoginSucessMessage> */}
                    {/* Username and password are controlled values */}
                    User Name:<input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                    Password:<input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>

            </div>

        )
    }

    loginClicked() {
        if (this.state.username === 'akhilesh' && this.state.password === 'dummy') {
            AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password);
            this.props.history.push(`/welcome/${this.state.username}`)
            // this.setState(
            //     {
            //         showSuccessMessage: true,
            //         hasLoginFailed: false
            //     }
            // )
        } else {
            console.log('Failed')
            this.setState(
                {
                    hasLoginFailed: true,
                    showSuccessMessage: false
                }
            )
        }

    }
}

// function ShowInvalidCredentials(props) {
//     if (props.hasLoginFailed)
//         return <div>Invalid Credntials</div>
//     else
//         return null
// }

// function ShowLoginSucessMessage(props) {
//     if (props.showSuccessMessage)
//         return <div>Login Successful</div>
//     else
//         return null
// }

export default TodoApp;