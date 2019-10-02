import React, { Component } from 'react';
import './Counter.css'
import PropTypes from 'prop-types'

class Counter extends Component {

    constructor() {
        super(); // this is must if you want to use this
        this.state = {
            counter: 0
        }

        this.increment = this.increment.bind(this)
        this.decrement = this.decrement.bind(this)
        this.reset = this.reset.bind(this)
    }

    render() {
        return (
            <div className="counter">
                <CounterButton incrementMethod={this.increment} decrementMethod={this.decrement} />
                <CounterButton incrementMethod={this.increment} decrementMethod={this.decrement} by={3} />
                <CounterButton incrementMethod={this.increment} decrementMethod={this.decrement} by={5} />
                <span className="count">{this.state.counter}</span>
                <div> <button onClick={this.reset} className="reset">Reset</button></div>
            </div>
        );
    }

    reset() {
        this.setState(

            { counter: 0 }

        );
    }

    increment(by) {
        // console.log(`increment from parent - ${by}`);
        this.setState(
            (prevState) => {
                return { counter: prevState.counter + by }
            }
        );
    }

    decrement(by) {
        // console.log(`increment from parent - ${by}`);
        this.setState(
            (prevState) => {
                return { counter: prevState.counter - by }
            }
        );
    }
}

class CounterButton extends Component {

    constructor() {
        super(); // this is must if you want to use this
        // this.state = {
        //     counter: 0
        // }

        // this.increment = this.increment.bind(this)
        // this.decrement = this.decrement.bind(this)
    }

    render() {
        return (
            <div className="counter">
                {/* The way we passed the argument/parameter is only possible due to this arrow syntax, 
                otherwise method will be called automatically */}
                <button onClick={() => this.props.incrementMethod(this.props.by)}>+{this.props.by}</button>
                <button onClick={() => this.props.decrementMethod(this.props.by)}>-{this.props.by}</button>
                {/* <span className="count">{this.state.counter}</span> */}
            </div>
        );
    }

    // increment() {
    //     console.log('increment from child');
    //     this.setState({
    //         counter: this.state.counter + this.props.by
    //     }
    //     );

    //     this.props.incrementMethod(this.props.by);
    // }


    // decrement() {
    //     console.log('decrement from child');
    //     this.setState({
    //         counter: this.state.counter - this.props.by
    //     }
    //     );

    //     this.props.decrementMethod(this.props.by);
    // }

}

CounterButton.defaultProps = {
    by: 1
}

CounterButton.propTypes = {
    by: PropTypes.number
}
export default Counter;
