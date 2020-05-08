import React, { Component } from "react";
import classes from "./Modal.module.css";
import Aux from "../../../hoc/Auxilary/Auxilary";
import Backdrop from "../Backdrop/Backdrop";

class Modal extends Component {

  shouldComponentUpdate(nextProps,nextState){
    return (nextProps.show !== this.props.show) || nextProps.children !== this.props.children;
  }

  componentDidUpdate(){
  }

  render() {
    return (
      <Aux>
        <Backdrop clicked={this.props.modalClosed} show={this.props.show}></Backdrop>
        <div
          className={classes.Modal}
          style={{
            transform: this.props.show ? "translateY(0)" : "translateY(-100vh)",
            opacity: this.props.show ? "1" : "0",
          }}
        >
          {this.props.children}
        </div>
      </Aux>
    );
  }
}

// const modal = (props) => (
//   <Aux>
//       <Backdrop clicked={props.modalClosed} show={props.show}></Backdrop>
//     <div
//       className={classes.Modal}
//       style={{
//         transform: props.show ? "translateY(0)" : "translateY(-100vh)",
//         opacity: props.show ? "1" : "0",
//       }}
//     >
//       {props.children}
//     </div>
//   </Aux>
// );

export default Modal;
