import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import axios from "axios"

//Global configurations
axios.defaults.baseURL = 'http://jsonplaceholder.typicode.com';
axios.defaults.headers.common['Authorization'] = 'AUTH TOKEN';
axios.defaults.headers.post['Content-type']='application/json'

//interceptors
axios.interceptors.request.use(
    request => {
        console.log(request);
        //customise request
        return request;
    }
, error => {
    console.log(error);
    return Promise.reject(error);
});


axios.interceptors.response.use(
    response => {
        console.log(response);
        //customise request
        return response;
    }
, error => {
    console.log(error);
    return Promise.reject(error);
});


ReactDOM.render( <App />, document.getElementById( 'root' ) );
registerServiceWorker();
