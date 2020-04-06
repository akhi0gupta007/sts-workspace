import React,{useEffect} from "react";
import classes from "./Cockpit.css";

const cockpit = (props) => {
  useEffect(() => {
    console.log('[cockpit.js] useEffect ');
    //Http request. it is componentdidupdate and componentdidmount in one effect
    //Fake timeout
    //can have many useffect
    const timer = setTimeout(() => {
      alert('Saved data to cloud');
    }, 2000);
    return () => {
      clearTimeout(timer);
      console.log('[cockpit.js] cleanup useEffect ');
    }
  }
    , []);

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
      <button onClick={() => props.clicked()} className={btnClass.join(" ")}>
        Toggle Persons
      </button>
    </div>
  );
};

export default React.memo(cockpit);
