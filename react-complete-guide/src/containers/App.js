import React, { Component } from "react";
import classes from "./App.css";
import Persons from "../components/Persons/Persons";
import Cockpit from "../components/Cockpit/Cockpit";

class App extends Component {
  state = {
    persons: [
      { id: "as1", name: "Akhilesh", age: 31 },
      { id: "as2", name: "Nancy", age: 32 },
      { id: "as3", name: "Aditi", age: 3 },
    ],
    otherStatus: "Guten morgen",
    showPersons: false,
  };

  switchMatchHandler = (newName) => {
    console.log("Was clicked" + this.state.persons);
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        { id: "as1", name: newName, age: 31 },
        { id: "as2", name: "Nancy", age: 32 },
        { id: "as3", name: "Aditi", age: 3 },
      ],
    });
  };

  deletePersonHandler = (index) => {
    //const persons = this.state.persons.slice(); //slice is copying
    const persons = [...this.state.persons]; //spread operator, does the copying
    persons.splice(index, 1);
    this.setState({ persons: persons });
  };

  nameChangeHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex((p) => {
      return p.id === id;
    });
    const person = {
      ...this.state.persons[personIndex],
    };
    //const altertNative = Object.assign({},this.state.persons[personIndex]); //does the same thing, i.e copy the object
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    person.name = event.target.value;
    const persons = [...this.state.persons];
    persons[personIndex] = person;
    this.setState({ persons: persons });
  };

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({
      showPersons: !doesShow,
    });
  };

  render() {
    let persons = null;
    if (this.state.showPersons) {
      persons = (
        <Persons
          persons={this.state.persons}
          clicked={this.deletePersonHandler}
          changed={this.nameChangeHandler}
        />
      );
    }

    return (
      <div className={classes.App}>
        <Cockpit
          showPersons={this.state.showPersons}
          persons={this.state.persons}
          clicked={this.togglePersonsHandler}
        />
        {persons}
      </div>
    );
  }
}

export default App;
