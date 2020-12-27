import react from 'react';
import './App.css';

let Container = (props) => {
    let title = props.title;
    return (<div className="Container">
            <div className="ContainerHeader"><h3>{props.title}</h3></div>
            <div className="ContainerBody">
                {props.children}
            </div>
        </div>);
}

export default Container;