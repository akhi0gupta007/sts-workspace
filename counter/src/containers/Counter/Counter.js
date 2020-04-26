import React, { Component } from 'react';
import {connect} from 'react-redux';
import CounterControl from '../../components/CounterControl/CounterControl';
import CounterOutput from '../../components/CounterOutput/CounterOutput';
import * as actionTypes from './../../store/actions';

class Counter extends Component {

    render () {
        return (
            <div>
                <CounterOutput value={this.props.ctr} />
                <CounterControl label="Increment" clicked={this.props.onIncrementCounter} />
                <CounterControl label="Decrement" clicked={this.props.onDecrementCounter}   />
                <CounterControl label="Add 10" clicked={this.props.onAddCounter}   />
                <CounterControl label="Substract 15" clicked={this.props.onSubstractCounter}   />
                <hr></hr>
                <button onClick={() => this.props.onStoreResult(this.props.ctr)}>Store Result</button>
                <ul>
                    {this.props.storedResults.map(strResult => (
                     <li key= {strResult.id} onClick={() => this.props.onDeleteResult(strResult.id)}>{strResult.value}</li>
                    ))}
                   
                </ul>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        ctr:state.ctr.counter, //ctr is used to access because nested reducers, see index.js file
        storedResults:state.res.results
    };
};

const mapDispatchToProps = dispatch =>{
    return {
        onIncrementCounter : () => dispatch({type:actionTypes.INCREMENT}),
        onDecrementCounter : () => dispatch({type:actionTypes.DECREMENT}),
        onAddCounter : () => dispatch({type:actionTypes.ADD,val:10}),
        onSubstractCounter : () => dispatch({type:actionTypes.SUBSTRACT,val:15}),
        onStoreResult : (resultStore) => dispatch({type:actionTypes.STORE_RESULT,result:resultStore}),
        onDeleteResult : (id) => dispatch({type:actionTypes.DELETE_RESULT,resultElId:id})
    };
};

export default connect(mapStateToProps,mapDispatchToProps)(Counter);