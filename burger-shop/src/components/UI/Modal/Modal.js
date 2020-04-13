import React from "react";
import classes from "./Modal.module.css";
import Aux from "../../../hoc/Auxilary";
import Backdrop from "../Backdrop/Backdrop";

const modal = (props) => (
  <Aux>
      <Backdrop clicked={props.modalClosed} show={props.show}></Backdrop>
    <div
      className={classes.Modal}
      style={{
        transform: props.show ? "translateY(0)" : "translateY(-100vh)",
        opacity: props.show ? "1" : "0",
      }}
    >
      {props.children}
    </div>
  </Aux>
);

export default modal;
