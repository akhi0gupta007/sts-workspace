const redux = require('redux');
const createStore = redux.createStore;
//Initialise state

const initalState = {
    counter:0
};
//Reducer
const rootReducer = (state = initalState, action) => { //ES 6 syntax
    if(action.type === 'INC_COUNTER'){
        return {
            ...state,
            counter:state.counter + 1
        };
    }
    if(action.type === 'ADD_COUNTER'){
        return {
            ...state,
            counter:state.counter + action.value
        };
    }
    return state; //returns new state
};

//Store
const store = createStore(rootReducer);
console.log(store.getState());

//Subscription, Function will be called upon dispatch
store.subscribe(() => {
    console.log('[Subscription]',store.getState());
});

//Dispatching action, kind of events
store.dispatch({type: 'INC_COUNTER'});
store.dispatch({type: 'ADD_COUNTER',value:10});
store.dispatch({type: 'INC_COUNTER'});

console.log(store.getState());

