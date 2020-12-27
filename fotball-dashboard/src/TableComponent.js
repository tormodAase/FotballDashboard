import React from 'react';
import './App.css';

let Table = (props) => {
    let table;

    if (props.array === undefined) {
        table = <div className="ErrorMessage">ERROR: props.array is undefined. Please contact Tormod for assistance</div>
    } else if (props.array[0] === undefined) {
        table = <div className="ErrorMessage">ERROR: props.array[0] is undefined. Please contact Tormod for assistance</div>
    } else {
        let rows = [];
        for (let i=0; i<props.array.length; i++) {
            let rowValues = [];
            for (let j=0; j<props.array[i].length; j++) {
                console.log(props.array[i][j])
                if (i === 0) {
                    rowValues.push(<th>{props.array[i][j]}</th>);
                } else {
                    rowValues.push(<td>{props.array[i][j]}</td>)
                }

            }

            rows.push(<tr>{rowValues}</tr>);
        }

        table = <table>{rows}</table>;
        
    }

    return table;
}

export default Table;