import React, { Component } from "react";

import Button from "../../../components/UI/Button/Button";
import axios from "../../../axios-orders";
import classes from "./ContactData.module.css";
import Spinner from "../../../components/UI/Spinner/Spinner";

class ContactData extends Component {
  state = {
    name: "",
    email: "",
    addres: {
      street: "",
      postalCode: "",
    },
    loading: false,
  };

  orderHandler = (event) => {
    event.preventDefault(); //Prevent form submit
    console.log("[ContactData.js]", this.props.ingredients);
    this.setState({ loading: true });
    const order = {
      ingredients: this.props.ingredients,
      price: this.props.price,
      customer: {
        name: "Akhilesh",
        address: {
          street: "Qutub vihar",
          zipCode: "110071",
          country: "India",
        },
        email: "akhi0gupta0007@gmail.com",
      },
      delivaryMethod: "fastest",
    };
    axios
      .post("/orders.json", order)
      .then((response) => {
        this.setState({ loading: false });
        this.props.history.push('/');
      })
      .catch((error) => {
        this.setState({ loading: false });
      });
  };

  render() {
    let form = (
      <form>
        <input
          className={classes.Input}
          type="text"
          name="name"
          placeholder="Your Name"
        />
        <input
          className={classes.Input}
          type="text"
          name="email"
          placeholder="Your email"
        />
        <input
          className={classes.Input}
          type="text"
          name="street"
          placeholder="Street"
        />
        <input
          className={classes.Input}
          type="text"
          name="postal"
          placeholder="PostalCode Code"
        />
        <Button btnType="Success" clicked={this.orderHandler}>
          ORDER
        </Button>
      </form>
    );
    if (this.state.loading) {
      form = <Spinner />;
    }
    return (
      <div className={classes.ContactData}>
        <h4>Enter your Contact details</h4>
        {form}
      </div>
    );
  }
}

export default ContactData;
