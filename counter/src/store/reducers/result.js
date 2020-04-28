// This is reducer import exists in index file

import * as actionTypes from "../actions/actionsTypes";
import { updateObject } from "../../store/utility";

const deleteResult = (state, action) => {
  const updatedArray = state.results.filter(
    (result) => result.id !== action.resultElId
  );
  return updateObject(state, { results: updatedArray });
};

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
      return deleteResult(state, action);
    default:
      return state;
  }
};

export default result;
