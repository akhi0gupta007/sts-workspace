import React, { Component } from 'react';
import './Counter.css'
import PropTypes from 'prop-types'

class Counter extends Component{
    render() {
        return (
          <div className="counter">  
          <CounterButton/>
          <CounterButton by ={3}/>
          <CounterButton by ={5}/>
          </div>
        );
      }
}

class CounterButton extends Component {
    //Define initial state in the constructor
    // state => counter 0

    constructor() {
        super(); // this is must if you want to use this
        this.state = {
            counter: 0
        }

        this.increment = this.increment.bind(this)
    }

    render() {
        return (
            <div className="counter">
                <button onClick={this.increment}>+{this.props.by}</button>
                <span className="count">{this.state.counter}</span>
            </div>
        );
    }

    increment() {
        console.log('increment');
        this.setState({
            counter: this.state.counter + this.props.by
        }
        );
    }

}

CounterButton.defaultProps = {
    by: 1
}

CounterButton.propTypes = {
    by: PropTypes.number
}
export default Counter;
