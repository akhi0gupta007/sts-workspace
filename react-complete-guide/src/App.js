import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  
  state = {
    persons: [
      { name: 'Akhilesh' , age:31},
      {name:'Nancy', age:32},
      {name:'Aditi', age:3}
    ],
    otherStatus:'Guten morgen'
  }

  switchMatchHandler = (newName) => {
    console.log('Was clicked'+this.state.persons);
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
    console.log('Was clicked'+this.state.persons);
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        { name: 'Max', age: 31 },
        { name: event.target.value, age: 32 },
        { name: 'Aditi', age: 3 }
      ]
    })
  }
  
  render() {
    return (
      <div className="App">
        <h1>Hi I am a react App</h1>
        <button onClick={() => this.switchMatchHandler('Akhilesh Gupta')}>Switch Name</button>
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}> </Person>
        <Person 
        click={this.switchMatchHandler.bind(this,'Vicky')} 
        name={this.state.persons[1].name} 
        age={this.state.persons[1].age} 
        changed={this.nameChangeHandler}>
        </Person>
        <Person name={this.state.persons[2].name} age={this.state.persons[2].age}>  My Hobbies : Racing</Person>
      </div>
    );
  }
}

export default App;
