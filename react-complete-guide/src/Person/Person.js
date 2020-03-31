import React from 'react';
import './Person.css';
import Radium from 'radium'

const person = (props) => {
    const style = {
        '@media(min-width:500px)':{
            width:'450px'
        }
    }
    return (
        <div className="Person" style={style} >
            <p>I am a {props.name} and I am {props.age} year old!</p>
            <p>{props.children}</p>
            <input type="text" onChange={props.changed} defaultValue ={props.name} />
            <button onClick={props.click}>Delete</button>
        </div>
    )
};

export default Radium(person);