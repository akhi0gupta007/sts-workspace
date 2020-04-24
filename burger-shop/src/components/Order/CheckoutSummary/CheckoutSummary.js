import React from "react";

import Burger from "../../Burger/Burger";
import Button from "../../UI/Button/Button";
import classes from "./CheckoutSummary.module.css";

const CheckoutSummary = (props) => {
    console.log(classes.CheckoutSummary);
    return (
        <div className={classes.CheckoutSummary}>
            <h1>We hope it tastes well!</h1>
            <div style={{width:'100%',margin:'auto'}}>
                <Burger ingredients={props.ingredients}></Burger>
            </div>
            <Button clicked={props.CheckoutCancelled} btnType="Danger">CANCEL</Button>
            <Button clicked={props.CheckoutContinue} btnType="Success">CONTINUE</Button>
        </div>
    );
};

export default CheckoutSummary;