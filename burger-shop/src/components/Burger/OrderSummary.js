import React, { Component } from "react";
import Aux from "../../hoc/Auxilary";
import Button from "../UI/Button/Button";

class OrderSummary extends Component {
 
  componentDidUpdate(){
    console.log("OrderSummary componentDidUpdate");
  }

  render() {
    const ingredientSummary = Object.keys(this.props.ingredients).map(
      (igKey) => {
        return (
          <li key={igKey}>
            <span style={{ textTransform: "capitalize" }}>{igKey} </span>:{" "}
            {this.props.ingredients[igKey]}
          </li>
        );
      }
    );

    return (
      <Aux>
        <h3>Your Orders</h3>
        <p>A Delicious burger with the following ingredients:</p>
        <ul>{ingredientSummary}</ul>
        <p>
          <strong>Total Price : {this.props.price.toFixed(2)}</strong>
        </p>
        <p>Continue to Checkout?</p>
        <Button btnType="Danger" clicked={this.props.purchaseCanceled}>
          CANCEL
        </Button>
        <Button btnType="Success" clicked={this.props.purchaseContinue}>
          CONTINUE
        </Button>
      </Aux>
    );
  }
}

// const orderSummary = (props) => {
//   const ingredientSummary = Object.keys(props.ingredients).map((igKey) => {
//     return (
//       <li key={igKey}>
//         <span style={{ textTransform: "capitalize" }}>{igKey} </span>:{" "}
//         {props.ingredients[igKey]}
//       </li>
//     );
//   });

//   return (
//     <Aux>
//       <h3>Your Orders</h3>
//       <p>A Delicious burger with the following ingredients:</p>
//       <ul>{ingredientSummary}</ul>
//       <p>
//         <strong>Total Price : {props.price.toFixed(2)}</strong>
//       </p>
//       <p>Continue to Checkout?</p>
//       <Button btnType="Danger" clicked={props.purchaseCanceled}>
//         CANCEL
//       </Button>
//       <Button btnType="Success" clicked={props.purchaseContinue}>
//         CONTINUE
//       </Button>
//     </Aux>
//   );
// };

export default OrderSummary;
