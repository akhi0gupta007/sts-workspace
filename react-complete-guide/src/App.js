import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  
  state = {
    persons: [
      { name: 'Akhilesh' , age:31},
      {name:'Nancy', age:32},
      {name:'Aditi', age:3}
    ]
  }

  switchMatchHandler = () => {
    console.log('Was clicked');
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        { name: 'Akhilesh kumar Gupta', age: 31 },
        { name: 'Nancy', age: 32 },
        { name: 'Aditi', age: 3 }
      ]
    })
  }
  
  render() {
    return (
      <div className="App">
        <h1>Hi I am a react App</h1>
        <button onClick={this.switchMatchHandler}>Switch Name</button>
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}> </Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}> </Person>
        <Person name={this.state.persons[2].name} age={this.state.persons[2].age}>  My Hobbies : Racing</Person>
      </div>
    );
  }
}

export default App;
