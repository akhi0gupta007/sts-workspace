import React, { Component } from "react";
import PropTypes from 'prop-types'

import classes from "./Person.css";
import Aux from "../../../hoc/Auxiliary";
import withClass2 from "../../../hoc/withClass2";
import AuthContext from "../../../context/auth-context";

class Person extends Component {

  constructor(props){
    super(props);
    this.inputElementRef = React.createRef();
  }

  componentDidMount(){
   /*  this.inputElement.focus(); */
   this.inputElementRef.current.focus(); //Generic way
  }

  render() {
    console.log("[Person.js] rendering...");

    return (
      <Aux>
        <AuthContext.Consumer>
          {(context) =>
            context.authenticated ? <p>Autheticated</p> : <p>Please log in</p>
          }
        </AuthContext.Consumer>

        <p>
          I am a {this.props.name} and I am {this.props.age} year old!
        </p>
        <p>{this.props.children}</p>
        <input
          /*  ref={(inputEl) =>{this.inputElement = inputEl}} */
          ref={this.inputElementRef}
          type="text"
          onChange={this.props.changed}
          defaultValue={this.props.name}
        />
        <button onClick={this.props.click}>Delete</button>
      </Aux>
    );
  }
}

Person.propTypes = {
  click: PropTypes.func,
  name: PropTypes.string,
  age: PropTypes.number,
  changed:PropTypes.func
};

export default withClass2(Person,classes.Person);
