import react from 'react'
import SearchBar from './SearchBarComponent'

let TopBar = (props) => {
    return <div className="TopBar">
        <h1 className="Title">FotballDashboard</h1>
        <SearchBar/>
    </div>;
}

export default TopBar;