import React,{PureComponent} from "react";
import Person from "./Person/Person";
class Persons extends PureComponent{


  // shouldComponentUpdate(nextProps,nextState){
  //   console.log('[Persons.js] shouldComponentUpdate');
  //   return (nextProps.persons !== this.props.persons) //No need to reload this component if there is no update;
  // }
  // * Use PureComponent do the same check insteaf of manually comparing individual checks

  getSnapshotBeforeUpdate(prevProps,prevState){
    console.log('[Persons.js] getSnapshotBeforeUpdate');
    return {message:'Snapshot!'};
  }

  componentDidUpdate(prevProps,prevState,snapshot){
    console.log('[Persons.js] componentDidUpdate',snapshot);    
  }

  componentWillUnmount(){
    console.log('[Persons.js] componentWillUnmount');
  }

  render(){
    console.log('[Persons.js] rendering...');
    return this.props.persons.map((person, index) => {
   
      return (
        <Person
          click={() => this.props.clicked(index)}
          name={person.name}
          age={person.age}
          key={person.id}
          changed={(event) => this.props.changed(event, person.id)}
        />
      );
    });
  }
}

export default Persons;
