import React, { Component } from 'react'

class TodoComponent extends Component {

    constructor(props) {
        super(props)
    }
    render() {
        return (
            <div className="container">
                Todo Component {this.props.match.params.id}
            </div>
        )
    }
}

export default TodoComponent