import React, { useEffect,useRef } from "react";
import classes from "./Cockpit.css";
import AuthContext from "../../context/auth-context"

const cockpit = (props) => {

  const toggleBtnRef = useRef(null);

  useEffect(() => {
    console.log("[cockpit.js] useEffect ");

    //useEffect is react hook executes after parsing JSX
    //Http request. it is componentdidupdate and componentdidmount in one effect
    //Fake timeout
    //can have many useffect

    // const timer = setTimeout(() => {
    //   alert("Saved data to cloud");
    // }, 2000);
    toggleBtnRef.current.click();
    return () => {
     // clearTimeout(timer);
      console.log("[cockpit.js] cleanup goes here after render useEffect ");
    };
  }, []);

  const assignedClasses = [];
  let btnClass = [];
  if (props.showPersons) {
    btnClass.push(classes.Red);
  }
  if (props.personsLength <= 2) {
    assignedClasses.push(classes.red);
  }
  if (props.personsLength <= 1) {
    assignedClasses.push(classes.bold);
  }
  return (
    <div className={classes.Cockpit}>
      <h1>{props.title}</h1>
      <p className={assignedClasses.join(" ")}>It works! Hello World</p>
      {/* <button onClick={props.clicked} className={btnClass.join(' ')}></button> 
            Alternative way of onClick method
            */}
      <button ref={toggleBtnRef} onClick={() => props.clicked()} className={btnClass.join(" ")}>
        Toggle Persons
      </button>
      <AuthContext.Consumer>
       {(context) =>  <button onClick={context.login}>Log in</button>} 
      </AuthContext.Consumer>
     
    </div>
  );
};

export default React.memo(cockpit);
