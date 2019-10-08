import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import HelloWorldService from '../../api/todo/HelloWorldService'
class WelcomeComponent extends Component {

    constructor(props){
        super(props)
        this.retrievemessage = this.retrievemessage.bind(this)
        this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this)
        this.state = {
            message:''
        }
    }
    render() {
        return (
            <>
                <h1>Welcome!</h1>
                <div className="container">

                    Welcome {this.props.match.params.name}. You can manage todos <Link to="/todos">here</Link>.
                {/* To avoid entire page refresh we are using Link tag */}

                </div>
                <div className="container">

               Click here to get customised welcome message <button className="btn btn-success" onClick={this.retrievemessage}>Get Welcome Message</button>

                </div>
                <div className="container">
                    {this.state.message}
                </div>
            </>
        )
    }

    retrievemessage(){
        HelloWorldService.executeHelloWorldPathService(this.props.match.params.name)
        .then(response => this.handleSuccessfulResponse(response))
        //.catch()
    }

    handleSuccessfulResponse(response) {
        this.setState(
            { message: response.data.message }
        )
    }
}
export default WelcomeComponent