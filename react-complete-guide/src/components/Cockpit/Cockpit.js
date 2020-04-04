import React from 'react';
import classes from './Cockpit.css'

const cockpit = (props) => {
    const assignedClasses = [];
    let btnClass = [];
    if (props.showPersons) {
        btnClass.push(classes.Red);
    }
    if (props.persons.length <= 2) {
        assignedClasses.push(classes.red);
    }
    if (props.persons.length <= 1) {
        assignedClasses.push(classes.bold);
    }
    return (
        <div className={classes.Cockpit}>
            <h1>Hi I am a react App</h1>
            <p className={assignedClasses.join(' ')}>It works! Hello World</p>
            {/* <button onClick={props.clicked} className={btnClass.join(' ')}></button> 
            Alternative way of onClick method
            */}
            <button onClick={() => props.clicked()} className={btnClass.join(' ')}>
                Toggle Persons
             </button>
        </div>

    )
};

export default cockpit;