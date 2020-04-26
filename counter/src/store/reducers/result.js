// This is reducer import exists in index file

import * as actionTypes from './../actions';

const initialState = {
  results: []
};
const result = (state = initialState, action) => {
  switch (action.type) {   
    case actionTypes.STORE_RESULT:
      return {
        ...state,
        results: state.results.concat({ id: new Date(), value: action.result }), //push updates origininal object, concat is immutable
      };
    case "DELETE_RESULT":
      // const id = 2;
      // const newArray = [...state.results];
      // newArray.splice(id,1);
      const updatedArray = state.results.filter(
        (result) => result.id !== action.resultElId
      );
      return {
        ...state,
        results: updatedArray, 
      };
    default:
      return state;
  }
};

export default result;
