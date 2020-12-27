import react from 'react';

let Container = (props) => {
    let title = props.title;
    return <div>{props.children}</div>
}

export default Container;