import React from "react";
import { Route, BrowserRouter, Switch } from "react-router-dom";
import { Provider } from "react-redux";
import {createStore,applyMiddleware,compose,combineReducers} from 'redux';
import thunk from 'redux-thunk';

import Layout from "./hoc/Layout/Layout";
import BurgerBuilder from "./containers/BurgerBuilder/BurgerBuilder";
import Checkout from "./containers/Checkout/Checkout";
import Orders from "./containers/Orders/Orders";
import burgerBuilderReducer from './store/reducers/burgerBuilder';
import orderReducer from './store/reducers/order';
import Auth from './containers/Auth/Auth';
import authReducer from './store/reducers/auth';
import Logout from './containers/Auth/Logout/Logout';

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const rootReducer = combineReducers({
  burgerBuilder:burgerBuilderReducer,
  order:orderReducer,
  auth:authReducer
});

const store = createStore(rootReducer,composeEnhancers(
  applyMiddleware(thunk) //thunk is the middleware we want to apply on store
));

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        {/*  We can also do it in index.js */}
        <div>
          <Layout>
            <Switch>
              <Route path="/checkout" component={Checkout} />
              <Route path="/orders" component={Orders} />
              <Route path="/auth" component={Auth} />
              <Route path="/logout" component={Logout} />
              <Route path="/" exact component={BurgerBuilder} />
            </Switch>
          </Layout>
        </div>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
