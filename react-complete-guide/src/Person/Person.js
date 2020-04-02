import React from 'react';
//import './Person.css';
import styled from 'styled-components'

const StyledDiv = styled.div`
    width: 60%;
    margin: 16px auto;
    border: 1px solid #eee;
    box-shadow: 0 2px 3px #46bd29;
    padding: 16px;
    text-align: center;   
    
     @media(min-width:500px){
            width: 450px;
    }
`;

const person = (props) => {
    // const style = {
    //     '@media(min-width:500px)': {
    //         width: '450px'
    //     }
    // }

    return (
        <StyledDiv>
            <p>I am a {props.name} and I am {props.age} year old!</p>
            <p>{props.children}</p>
            <input type="text" onChange={props.changed} defaultValue={props.name} />
            <button onClick={props.click}>Delete</button>
        </StyledDiv>

    )
};

export default person;