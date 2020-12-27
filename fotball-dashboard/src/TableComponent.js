import React from 'react';
import './App.css';

let Table = (props) => {
    let table = "";
    if (props.array === undefined) {
        table = <div className="ErrorMessage">ERROR: props.array is undefined. Please contact Tormod for assistance</div>
    } else if (props.array[0] === undefined) {
        table = <div className="ErrorMessage">ERROR: props.array[0] is undefined. Please contact Tormod for assistance</div>
    }
    return table;
}

export default Table;