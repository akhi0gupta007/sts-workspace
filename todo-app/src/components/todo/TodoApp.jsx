import React, { Component } from 'react'

class TodoApp extends Component {

    render() {
        return (
            <div className="TodoApp">
                <LoginComponent />
            </div>
        )
    }
}


class LoginComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            username: 'akhilesh',
            password: ''
        }

        this.handleUserNameChange = this.handleUserNameChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
    }

    handleUserNameChange(event) {
        console.log(event.target.value);
        this.setState({
            username: event.target.value
        });
    }


    handlePasswordChange(event) {
        console.log(event.target.value);
        this.setState({
            password: event.target.value
        });
    }

    handleChange(event) {
        console.log(event.target.value);
        this.setState({
            username: event.target.value
        });
    }

    render() {
        return (
            <div>
                {/* Username and password are controlled values */}
                User Name:<input type="text" name="username" value={this.state.username} onChange={this.handleUserNameChange} />
                Password:<input type="password" name="password" value={this.state.password} onChange={this.handlePasswordChange} />
                <button>Login</button>
            </div>

        )
    }
}

export default TodoApp;