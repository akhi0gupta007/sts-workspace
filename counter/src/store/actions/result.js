import * as actionTypes from './actionsTypes';

export const saveResult = (res) => {
    return{
        type: actionTypes.STORE_RESULT,
        result:res
    };
};

// export const storeResult = (res) => {
//     return dispatch => { //returns function
//         setTimeout(() => {
//             dispatch(saveResult(res));
//         },2000); //Trying to imitate asyn behaviour
//     }    
// };
//Advance version in thunk
export const storeResult = (res) => {
    return (dispatch,getState) => { //returns function
        setTimeout(() => {
            const oldCounter = getState().ctr.counter;
            console.log('[result.js] actionType',oldCounter);
            dispatch(saveResult(res));
        },2000); //Trying to imitate asyn behaviour
    }    
};

export const deleteResult = (delId) => {
    return{
        type: actionTypes.DELETE_RESULT,
        resultElId:delId
    };
};