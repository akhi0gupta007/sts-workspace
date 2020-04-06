import React from "react";
const withCLass2 = (WrappedComponent,className) =>{
    return props =>(
        <div className={className}>
            <WrappedComponent/>
        </div>
    );
};

export default withCLass2;