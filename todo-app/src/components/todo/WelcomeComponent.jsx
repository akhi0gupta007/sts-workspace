import React, { Component } from 'react'
import { Link } from 'react-router-dom'
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
export default WelcomeComponent