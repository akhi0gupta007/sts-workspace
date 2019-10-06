import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import AuthenticationService from './AuthenticationService.js'
import { withRouter } from "react-router";

class HeaderComponent extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        console.log("logged in "+isUserLoggedIn);
        return (

            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a className="navbar-brand" href="/">Akhilesh Todos</a></div>
                    <ul className="navbar-nav">
                        {isUserLoggedIn && <li ><Link to="/welcome/akhilesh" className="nav-link">Home</Link></li>}
                        {isUserLoggedIn && <li ><Link to="/todos" className="nav-link">Todos</Link></li>}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li ><Link to="/login" className="nav-link">Login</Link></li>}
                        {isUserLoggedIn && <li ><Link to="/logout" className="nav-link" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(HeaderComponent)