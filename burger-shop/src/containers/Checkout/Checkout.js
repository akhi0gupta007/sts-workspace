import React, { Component } from "react";
import { Route } from "react-router-dom";

import CheckoutSummary from "../../components/Order/CheckoutSummary/CheckoutSummary";
import ContactData from "../../containers/Checkout/ContactData/ContactData";

class Checkout extends Component {
  state = {
    ingredients:null,
    price:0
  };

  constructor(props){
    super(props);
  }

  
  
  componentWillMount() {
    const query = new URLSearchParams(this.props.location.search);
    const ingredients = {};
    let price = 0;
    for (let param of query.entries()) {
      if (param[0] === "price") {
        //This is workaround
        price = param[1];
      } else {
        ingredients[param[0]] = +param[1]; // Adding + so that string is converted to a number
      }
    }
    this.setState({ ingredients: ingredients ,totalPrice:price});
  }

  checkoutContinueHandler = () => {
    this.props.history.replace("/checkout/contact-data");
  };

  checkoutCancelledHandler = () => {
    this.props.history.goBack();
  };

  render() {
    return (
      <div>
        <CheckoutSummary
          CheckoutCancelled={this.checkoutCancelledHandler}
          CheckoutContinue={this.checkoutContinueHandler}
          ingredients={this.state.ingredients}
        ></CheckoutSummary>
        <Route
          path={this.props.match.path + "/contact-data"}
          render={(props) => <ContactData ingredients={this.state.ingredients} price={this.state.totalPrice} {...props} />}
        ></Route>
      </div>
    );
  }
}

export default Checkout;
