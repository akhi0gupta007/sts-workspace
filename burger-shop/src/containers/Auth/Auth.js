import React, { Component } from "react";
import { connect } from "react-redux";
import { Redirect } from "react-router-dom";

import Input from "../../components/UI/Input/Input";
import Button from "../../components/UI/Button/Button";
import classes from "./Auth.module.css";
import Spinner from "../../components/UI/Spinner/Spinner";
import * as actions from "../../store/actions/index";
import { updateObject,checkValidity } from "../../shared/utility";

class Auth extends Component {
  state = {
    contorls: {
      email: {
        elementType: "input",
        elementConfig: {
          type: "email",
          placeholder: "Mail Address",
        },
        value: "",
        validation: {
          required: true,
          isEmail: true,
        },
        valid: false,
        touched: false,
      },
      password: {
        elementType: "input",
        elementConfig: {
          type: "password",
          placeholder: "Password",
        },
        value: "",
        validation: {
          required: true,
          minLength: 6,
        },
        valid: false,
        touched: false,
      },
    },
    isSignup: true,
  };

  componentDidMount() {
    if (!this.props.buildingBurger && this.props.authRedirectPath !== "/") {
      this.props.onSetAuthRedirectPath();
    }
  }

  //This is two way binding, event is default param but id is not old way
  // inputChangedHandler = (event, controlName) => {
  //   const updatedControls = {
  //     ...this.state.contorls,
  //     [controlName]: {
  //       ...this.state.contorls[controlName],
  //       value: event.target.value,
  //       valid: this.checkValidity(
  //         event.target.value,
  //         this.state.contorls[controlName].validation
  //       ),
  //       touched: true,
  //     },
  //   };
  //   this.setState({ contorls: updatedControls });
  // };

  //Refractored, using utilities
  inputChangedHandler = (event, controlName) => {
    const updatedControls = updateObject(this.state.contorls, {
      [controlName]: updateObject(this.state.contorls[controlName], {
        value: event.target.value,
        valid: checkValidity(
          event.target.value,
          this.state.contorls[controlName].validation
        ),
        touched: true,
      }),    
    });
    this.setState({ contorls: updatedControls });
  };


  render() {
    const formElementsArray = [];
    for (let key in this.state.contorls) {
      formElementsArray.push({
        id: key,
        config: this.state.contorls[key],
      });
    }
    let form = formElementsArray.map((formElement) => (
      <Input
        key={formElement.id}
        elementType={formElement.config.elementType}
        elementConfig={formElement.config.elementConfig}
        value={formElement.config.value}
        invalid={!formElement.config.valid}
        shouldValidate={formElement.config.validation}
        touched={formElement.config.touched}
        changed={(event) => this.inputChangedHandler(event, formElement.id)}
      ></Input>
    ));
    if (this.props.loading) {
      form = <Spinner />;
    }

    let errrorMessage = null;

    if (this.props.error) {
      errrorMessage = <p>{this.props.error.message}</p>;
    }
    let authRedirect = null;
    if (this.props.isAuthenticated) {
      authRedirect = <Redirect to={this.props.authRedirectPath} />;
    }

    return (
      <div className={classes.Auth}>
        {authRedirect}
        {errrorMessage}
        <form onSubmit={this.submitHandler}>
          {form}
          <Button btnType="Success">SUBMIT</Button>
        </form>
        <Button clicked={this.switchAuthModeHandler} btnType="Danger">
          SWITCH TO {this.state.isSignup ? "SIGNIN" : "SIGNUP"}
        </Button>
      </div>
    );
  }

  submitHandler = (event) => {
    event.preventDefault();
    this.props.onAuth(
      this.state.contorls.email.value,
      this.state.contorls.password.value,
      this.state.isSignup
    );
  };

  switchAuthModeHandler = () => {
    this.setState((prevState) => {
      return { isSignup: !prevState.isSignup };
    });
  };
}

const mapStateToProps = (state) => {
  return {
    loading: state.auth.loading,
    error: state.auth.error,
    isAuthenticated: state.auth.token !== null,
    buildingBurger: state.burgerBuilder.building,
    authRedirectPath: state.auth.authRedirectPath,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    onAuth: (email, password, isSignup) =>
      dispatch(actions.auth(email, password, isSignup)),
    onSetAuthRedirectPath: () => dispatch(actions.setAuthRedirectPath("/")),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Auth);
