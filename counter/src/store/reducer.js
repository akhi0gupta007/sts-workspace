const initialState = {
  counter: 0,
  results: [],
};
const reducer = (state = initialState, action) => {
  switch (action.type) {
    case "INCREMENT":
      const newState = Object.assign({}, state); //Creating new object here for immutability, better way is below
      newState.counter = state.counter + 1;
      return newState;
    case "DECREMENT":
      return {
        ...state,
        counter: state.counter - 1,
      };
    case "ADD":
      return { ...state, counter: state.counter + action.val };
    case "SUBSTRACT":
      return { ...state, counter: state.counter - action.val };
    case "STORE_RESULT":
      return {
        ...state,
        results: state.results.concat({ id: new Date(), value: state.counter }), //push updates origininal object, concat is immutable
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
        results: updatedArray, //push updates origininal object, concat is immutable
      };
    default:
      return state;
  }
};

export default reducer;
