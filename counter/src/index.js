import React from 'react';
import ReactDOM from 'react-dom';
import {createStore,combineReducers,applyMiddleware,compose} from 'redux';
import {Provider} from 'react-redux';
import thunk from 'redux-thunk';

import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import counterReducer  from './store/reducers/counterReducer';
import resultReducer  from './store/reducers/result';

const rootReducer = combineReducers({
    ctr : counterReducer,
    res:resultReducer
});


const logger  = store => {
    return next => {
      return  action => {
        console.log('[Middleware] Dispacthing',action);
        const result = next(action);
        console.log('[Middleware]',store.getState());
        return result;
      }
    }
  };

  const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

  const store = createStore(rootReducer,composeEnhancers(applyMiddleware(logger,thunk))); //can pas list of middle ware

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));
registerServiceWorker();
