import React from "react";
import { Route, BrowserRouter, Switch } from "react-router-dom";
import { Provider } from "react-redux";
import {createStore} from 'redux';

import Layout from "./hoc/Layout/Layout";
import BurgerBuilder from "./containers/BurgerBuilder/BurgerBuilder";
import Checkout from "./containers/Checkout/Checkout";
import Orders from "./containers/Orders/Orders";
import reducer from './store/reducer'

const store = createStore(reducer);

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
              <Route path="/" exact component={BurgerBuilder} />
            </Switch>
          </Layout>
        </div>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
