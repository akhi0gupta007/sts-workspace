import React from 'react';
import classes from './Person.css';


const person = (props) => {


    return (
        <div className={classes.Person}>
            <p>I am a {props.name} and I am {props.age} year old!</p>
            <p>{props.children}</p>
            <input type="text" onChange={props.changed} defaultValue={props.name} />
            <button onClick={props.click}>Delete</button>
        </div>

    )
};

export default person;