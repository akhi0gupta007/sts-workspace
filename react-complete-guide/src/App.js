import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {

  state = {
    persons: [
      {id: 'as1', name: 'Akhilesh', age: 31 },
      {id: 'as2', name: 'Nancy', age: 32 },
      {id: 'as3', name: 'Aditi', age: 3 }
    ],
    otherStatus: 'Guten morgen',
    showPersons: false
  } 

  switchMatchHandler = (newName) => {
    console.log('Was clicked' + this.state.persons);
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    this.setState({
      persons: [
        {id: 'as1', name: newName, age: 31 },
        {id: 'as2', name: 'Nancy', age: 32 },
        {id: 'as3', name: 'Aditi', age: 3 }
      ]
    })
  }

  deletePersonHandler = (index) => {
    //const persons = this.state.persons.slice(); //slice is copying
    const persons = [...this.state.persons]; //spread operator, does the copying
    persons.splice(index, 1);
    this.setState({ persons: persons });
  }

  nameChangeHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(
      p => {
        return p.id === id;
      }
    );
    const person = {
    ...this.state.persons[personIndex]
    };
    //const altertNative = Object.assign({},this.state.persons[personIndex]); //does the same thing, i.e copy the object
    //DON'T DO THIS this.state.persons[0].name = 'Akhilesh Kumar Gupta';
    person.name = event.target.value;
    const persons = [...this.state.persons];
    persons[personIndex] = person;
    this.setState({persons:persons});
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({
      showPersons: !doesShow
    })
  }

  render() {


    const style = {
      backgroundColor: 'green',
      color:'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px', 
      cursor: 'pointer',
      ':hover':{
        backgroundColor:'lightgreen',
        color:'black'
      }
    };
    //Install new package npm install --save radium
    let persons = null;

    if (this.state.showPersons) {
      persons = (
        <div>
          {this.state.persons.map((person, index) => {
            return <Person
              click={() => this.deletePersonHandler(index)}
              name={person.name}
              age={person.age}
              key={person.id} 
              changed = {(event) => this.nameChangeHandler(event,person.id) }/>
          })}
        </div>
      )

      // style.backgroundColor = 'red';
      // style[':hover'] = {
      //   backgroundColor:'salmon',
      //   color:'black'
      // }
    }
    const classes = [];
    if (this.state.persons.length <= 2) {
      classes.push('red');
    }
    if (this.state.persons.length <= 1) {
      classes.push('bold');
    }

    return (
      <div className="App">
        <h1>Hi I am a react App</h1>
        <p className={classes.join(' ')}>It works! Hello World</p>
        {/* <button
          style={style}
          onClick={() => this.switchMatchHandler('Akhilesh Gupta')}>Switch Name</button> */}

        <button onClick={() => this.togglePersonsHandler()} className='button'>
          Toggle Persons
          </button>
        {persons}
      </div>
    );
  }
}

export default App;
