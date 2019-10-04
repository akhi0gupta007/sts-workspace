import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

class TodoApp extends Component {

    render() {
        return (
            <div className="TodoApp">
                <Router>
                    <>
                        <Switch>
                            <Route path="/" exact component={LoginComponent}></Route>
                            <Route path="/login" component={LoginComponent}></Route>
                            <Route path="/welcome/:name" component={WelcomeComponent}></Route>
                            <Route path="" component={ErrorComponent}></Route>
                        </Switch>
                    </>
                </Router>
                {/* <LoginComponent /> */}
            </div>
        )
    }
}

class WelcomeComponent extends Component {
    render() {
        return <div>Welcome {this.props.match.params.name}</div>
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
                {/*  <ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}></ShowInvalidCredentials> */}
                {this.state.hasLoginFailed && <div>Invalid Credntials</div>}
                {this.state.showSuccessMessage && <div>Login Successful</div>}
                {/* optimised functional component
               <ShowLoginSucessMessage showSuccessMessage={this.state.showSuccessMessage}></ShowLoginSucessMessage> */}
                {/* Username and password are controlled values */}
                User Name:<input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                Password:<input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                <button onClick={this.loginClicked}>Login</button>
            </div>

        )
    }

    loginClicked() {
        if (this.state.username === 'akhilesh' && this.state.password === 'dummy') {

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