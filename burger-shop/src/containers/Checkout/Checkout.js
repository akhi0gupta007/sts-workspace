import React, { Component } from "react";
import { Route } from "react-router-dom";
import {connect} from 'react-redux';

import CheckoutSummary from "../../components/Order/CheckoutSummary/CheckoutSummary";
import ContactData from "../../containers/Checkout/ContactData/ContactData";

class Checkout extends Component {

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
          ingredients={this.props.ings}
        ></CheckoutSummary>
        <Route
          path={this.props.match.path + "/contact-data"}
         component = {ContactData}
        ></Route>
      </div>
    );
  }
}

const mapStateToProps= state => {
  return {
    ings : state.ingredients
  };
}

export default  connect(mapStateToProps)(Checkout);
