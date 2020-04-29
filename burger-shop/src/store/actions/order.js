import * as actionTypes from './actionTypes';
import axios from '../../axios-orders';

//SYNCRONOUS ACTION CREATORS FOR DELEGATING TO REDUCERS

export const purchaseBurgerSuccess = (id,orderData) => {
    return {
        type:actionTypes.PURCHASE_BURGER_SUCCESS,
        orderId : id,
        orderData:orderData
    }
};

export const purchaseBurgerFail = (error) => {
    return{
        type:actionTypes.PURCHASE_BURGER_FAIL,
        error:error
    }
};

export const purchaseBurgerStart = () => {
    return {
        type : actionTypes.PURCHASE_BURGER_START
    };
};

//ASYNC ONE
export const purchaseBurger = (orderData) => {
    return dispatch => { // This syntax is due to redux thunk middleware, whicn enables us to create action creators like this
        dispatch(purchaseBurgerStart());
        axios
        .post("/orders.json", orderData)
        .then((response) => {
            console.log('[order.js] action',response.data);
            dispatch(purchaseBurgerSuccess(response.data.name,orderData))
        })
        .catch((error) => {
            dispatch(purchaseBurgerFail(error));
        });
    };
}