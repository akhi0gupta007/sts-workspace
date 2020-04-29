//SYNCRONOUS ACTION CREATORS
import * as actionTypes from './actionTypes';
import axios from '../../axios-orders';

export const addIngredient = (name) => {
    return {
        type:actionTypes.ADD_INGREDIENT,
        ingredientName:name
    }
};

export const removeIngredient = (name) => {
    return {
        type:actionTypes.REMOVE_INGREDIENT,
        ingredientName:name
    }
};

export const setIngredients = (ingredients) => {
    return{
        type:actionTypes.SET_INGREDIENTS,
        ingredients:ingredients
    };
}

export const fetchIngredientsFailed = () => {
    return{
        type: actionTypes.FETCH_INGREDIENTS_FAILED
    };
};

//ASYNC ONE
export const initIngredients = () => { 
    return dispatch =>  { // This syntax is due to redux thunk middleware, whicn enables us to create action creators like this
        console.log('initIngredients action');
    axios
      .get("/ingredients.json")
      .then((response) => {
        dispatch(setIngredients(response.data));
      })
      .catch((error) => {
        dispatch(fetchIngredientsFailed());
      });
    };
}