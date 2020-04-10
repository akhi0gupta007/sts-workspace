import React from "react";
const withCLass2 = (WrappedComponent,className) =>{
    return props =>(
        <div className={className}>
            <WrappedComponent {...props} /> {/* This spread operator passes the props across component */}
        </div>
    );
};

export default withCLass2;