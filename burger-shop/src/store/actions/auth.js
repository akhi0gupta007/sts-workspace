import * as actionTypes from "./actionTypes";
import axios from "axios";

export const authStart = () => {
  return {
    type: actionTypes.AUTH_START,
  };
};

export const authSuccess = (token,userId) => {
  return {
    type: actionTypes.AUTH_SUCESS,
    idToken:token,
    userId:userId
  };
};

export const authFail = (error) => {
  return {
    type: actionTypes.AUTH_FAIL,
    error: error,
  };
};

export const auth = (email, password,isSignup) => {
  return (dispatch) => {
    dispatch(authStart());
    const authData = {
      email: email,
      password: password,
      returnSecureToken: true,
    };
    let url = 'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyBIu7vs0sdAxHgnqsdbaZj0qIaJcGJ8QIQ';
    if(!isSignup){
        url = 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBIu7vs0sdAxHgnqsdbaZj0qIaJcGJ8QIQ';
    }
    axios
      .post(
        url,
        authData
      )
      .then((response) => {
        console.log(response);
        dispatch(authSuccess(response.data.idToken,response.data.localId));
      })
      .catch((err) => {
        console.log(err);
        console.log(err.response.data.error.message)
        dispatch(authFail(err));
      });
  };
};
