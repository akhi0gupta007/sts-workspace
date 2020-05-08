import React, { Component } from "react";
import {connect} from 'react-redux';


import Button from "../../../components/UI/Button/Button";
import axios from "../../../axios-orders";
import classes from "./ContactData.module.css";
import Spinner from "../../../components/UI/Spinner/Spinner";
import Input from "../../../components/UI/Input/Input";
import withErrorHandler from '../../../hoc/withErrorHandler/withErrorHandler';
import * as actions from '../../../store/actions/index';

class ContactData extends Component {
  state = {
    orderForm: {
      name: {
        elementType: "input",
        elementConfig: {
          type: "text",
          placeholder: "Your Name",
        },
        value: "",
        validation: {
          required: true,
        },
        valid: false,
        touched: false,
      },
      street: {
        elementType: "input",
        elementConfig: {
          type: "text",
          placeholder: "Street",
        },
        value: "",
        validation: {
          required: true,
        },
        valid: false,
        touched: false,
      },
      zipCode: {
        elementType: "input",
        elementConfig: {
          type: "text",
          placeholder: "Zipcode",
        },
        value: "",
        validation: {
          required: true,
          minLength: 5,
          maxLength: 5,
        },
        valid: false,
        touched: false,
      },
      country: {
        elementType: "input",
        elementConfig: {
          type: "text",
          placeholder: "Country",
        },
        value: "",
        validation: {
          required: true,
        },
        valid: false,
        touched: false,
      },
      email: {
        elementType: "input",
        elementConfig: {
          type: "email",
          placeholder: "Your email",
        },
        value: "",
        validation: {
          required: true,
        },
        valid: false,
        touched: false,
      },
      delivaryMethod: {
        elementType: "select",
        elementConfig: {
          options: [
            {
              value: "fastest",
              displayValue: "Fastest",
            },
            {
              value: "cheapest",
              displayValue: "Cheapest",
            },
          ],
        },
        value: "fastest",
        valid:true
      },
    },
    formIsValid:false   
  };

  orderHandler = (event) => {
    event.preventDefault(); //Prevent form submit
    console.log("[ContactData.js]", this.props.ings);
    const formData = {};    
    for (let formElementIdentifier in this.state.orderForm) {
      formData[formElementIdentifier] = this.state.orderForm[
        formElementIdentifier
      ].value;
    }
    const order = {
      ingredients: this.props.ings,
      price: this.props.totalPrice,
      orderData: formData,
      userId:this.props.userId
    };  
    this.props.onOrderBurger(order,this.props.token); 
  };

  checkValidity(value, rules) {
    if(!rules){ //null check
      return true;
    }
    let isValid = true;
    if (rules.required) {
      isValid = value.trim() !== "" && isValid;
    }
    if (rules.minLength) {
      isValid = value.length >= rules.minLength && isValid;
    }
    if (rules.maxLength) {
      isValid = value.length <= rules.maxLength && isValid;
    }
    return isValid;
  }

  //This is two way binding, event is default param but id is not
  inputChangedHandler = (event, id) => {
    const updatedOrderForm = {
      ...this.state.orderForm, //This is deep cloning
    };
    const updatedFormElement = { ...updatedOrderForm[id] }; //This is deep cloning
    updatedFormElement.value = event.target.value;
    updatedFormElement.valid = this.checkValidity(
      updatedFormElement.value,
      updatedFormElement.validation
    );
    updatedFormElement.touched=true;
    console.log(updatedFormElement.valid);
    updatedOrderForm[id] = updatedFormElement;
    let formIsValid = true;
    for(let id in updatedOrderForm){
      formIsValid = updatedOrderForm[id].valid && formIsValid;
    }
    this.setState({ orderForm: updatedOrderForm, formIsValid:formIsValid});
  };

  render() {
    const formElementsArray = [];
    for (let key in this.state.orderForm) {
      formElementsArray.push({
        id: key,
        config: this.state.orderForm[key],
      });
    }

    let form = (
      <form onSubmit={this.orderHandler}>
        {formElementsArray.map((formElement) => (
          <Input
            key={formElement.id}
            elementType={formElement.config.elementType}
            elementConfig={formElement.config.elementConfig}
            value={formElement.config.value}
            invalid={!formElement.config.valid}
            shouldValidate={formElement.config.validation}
            touched = {formElement.config.touched}
            changed={(event) => this.inputChangedHandler(event, formElement.id)}
          />
        ))}
        <Button disabled={!this.state.formIsValid} btnType="Success">ORDER</Button>
      </form>
    );
    if (this.props.loading) {
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

const mapStateToProps= state => {
  return {
    ings : state.burgerBuilder.ingredients,
    totalPrice : state.burgerBuilder.totalPrice,
    loading: state.order.loading,
    token:state.auth.token,
    userId:state.auth.userId
  };
}

const mapDispatchToProps = dispatch => {
  return{
    onOrderBurger: (orderData,token) => dispatch(actions.purchaseBurger(orderData,token))
  } 
};

export default connect(mapStateToProps,mapDispatchToProps)(withErrorHandler(ContactData,axios));
