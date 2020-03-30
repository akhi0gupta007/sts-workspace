import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {

  state = {
    persons: [
      { name: 'Akhilesh', age: 31 },
      { name: 'Nancy', age: 32 },
      { name: 'Aditi', age: 3 }
    ],
    otherStatus: 'Guten morgen',
    showPersons: false
  }

  switchMatchHandler = (newName) => {
    console.log('Was clicked' + this.state.persons);
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        { name: newName, age: 31 },
        { name: 'Nancy', age: 32 },
        { name: 'Aditi', age: 3 }
      ]
    })
  }

  nameChangeHandler = (event) => {
    console.log('Was clicked' + this.state.persons);
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        { name: 'Max', age: 31 },
        { name: event.target.value, age: 32 },
        { name: 'Aditi', age: 3 }
      ]
    })
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({
      showPersons: !doesShow
    })
  }

  render() {

    const style = {
      backgroudColor: 'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px',
      cursor: 'pointer'
    };

    let person = null;

    if(this.state.showPersons){
      person = (
        <div>
          <Person name={this.state.persons[0].name} age={this.state.persons[0].age}> </Person>
          <Person
            click={this.switchMatchHandler.bind(this, 'Vicky')}
            name={this.state.persons[1].name}
            age={this.state.persons[1].age}
            changed={this.nameChangeHandler}>
          </Person>
          <Person name={this.state.persons[2].name} age={this.state.persons[2].age}>  My Hobbies : Racing
        </Person>
        </div>
      )
    }

    return (
      <div className="App">
        <h1>Hi I am a react App</h1>
        <button
          style={style}
          onClick={() => this.switchMatchHandler('Akhilesh Gupta')}>Switch Name</button>

        <button
          style={style}
          onClick={() => this.togglePersonsHandler()}>Toggle Persons</button>      
          {person}
      </div>
    );
  }
}

export default App;
