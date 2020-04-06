import React, { Component } from "react";
import classes from "./Person.css";
import Aux from "../../../hoc/Auxiliary";
import withClass2 from "../../../hoc/withClass2";

class Person extends Component {
  render() {
    console.log("[Person.js] rendering...");

    return (
      <Aux> 
        <p>
          I am a {this.props.name} and I am {this.props.age} year old!
        </p>
        <p>{this.props.children}</p>
        <input
          type="text"
          onChange={this.props.changed}
          defaultValue={this.props.name}
        />
        <button onClick={this.props.click}>Delete</button>
        </Aux> 
    );
  }
}

export default withClass2(Person,classes.Person);
