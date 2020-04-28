import * as actionTypes from "../actions/actionsTypes";
import { updateObject } from "../../store/utility";

const initialState = {
  counter: 0,
};
const counterReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.INCREMENT:
      const newState = Object.assign({}, state); //Creating new object here for immutability, better way is below
      newState.counter = state.counter + 1;
      return newState;
    case actionTypes.DECREMENT:
      return updateObject(state, { counter: state.counter - 1 }); // this is better way, as compare to above way
    case actionTypes.ADD:
      return updateObject(state, { counter: state.counter + action.val });
    case actionTypes.SUBSTRACT:
      return updateObject(state, { counter: state.counter - action.val });
    default:
      return state;
  }
};

export default counterReducer;
