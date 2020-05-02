import React, { Component } from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "react-redux";

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
    let summary = <Redirect to="/" />;
    
    if (this.props.ings) {
    const puchaseRedirect = this.props.purchased ? <Redirect to="/"></Redirect>:null;
     summary =  <div>
       {puchaseRedirect} 
        <CheckoutSummary
          CheckoutCancelled={this.checkoutCancelledHandler}
          CheckoutContinue={this.checkoutContinueHandler}
          ingredients={this.props.ings}
        ></CheckoutSummary>
        <Route
          path={this.props.match.path + "/contact-data"}
          component={ContactData}
        ></Route>
      </div>;
    }
    return summary;
  }
}

const mapStateToProps = (state) => {
  return {
    ings: state.burgerBuilder.ingredients,
    purchased:state.order.purchased
  };
};

export default connect(mapStateToProps)(Checkout);
