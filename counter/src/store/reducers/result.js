// This is reducer import exists in index file

import * as actionTypes from "../actions/actionsTypes";
import { updateObject } from "../../store/utility";

const initialState = {
  results: [],
};
const result = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.STORE_RESULT:
      return updateObject(state, {
        results: state.results.concat({ id: new Date(), value: action.result }),
      });
    case actionTypes.DELETE_RESULT:
      // const id = 2;
      // const newArray = [...state.results];
      // newArray.splice(id,1);
      const updatedArray = state.results.filter(
        (result) => result.id !== action.resultElId
      );
      return updateObject (state,{ results: updatedArray});
    default:
      return state;
  }
};

export default result;
