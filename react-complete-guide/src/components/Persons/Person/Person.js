import React,{Component} from "react";
import classes from "./Person.css";

class Person extends Component{

  render(){
    console.log('[Person.js] rendering...');
    
    return(
      <div className={classes.Person}>
      <p>
        I am a {this.props.name} and I am {this.props.age} year old!
      </p>
      <p>{this.props.children}</p>
      <input type="text" onChange={this.props.changed} defaultValue={this.props.name} />
      <button onClick={this.props.click}>Delete</button>
    </div>
    );
  }
}

export default Person;
