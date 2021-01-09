import react, {useState} from 'react'

let SearchBar = (props) => {
    const SEARCHDEFAULTVALUE = "Search"
    const [searchValue, setSearchValue] = useState(SEARCHDEFAULTVALUE);
    const [searchResultOpacity, setSearchResultOpacity] = useState(0);

    const searchResults = getSearchResults();

    function handleChange(e) {
        console.log(e);
        setSearchValue(e.target.value)
    }

    if (searchResultOpacity < 1) {
        setSearchResultOpacity(searchResultOpacity+0.1);
    }

    function getSearchResults() {
        if (searchValue.length > 0 && searchValue != SEARCHDEFAULTVALUE) {
            return <div style={{height: '300px', width: '100%', backgroundColor: 'white', alignSelf: 'center', width: '50%', borderRadius: '25px', border: '1px solid grey', boxShadow: '0px 0px 5px', padding: '10px', zIndex: 10, position: 'relative', opacity: searchResultOpacity}}>Results</div>
        }
    }

    return <div><form className="SearchBar">
        <input onChange={(e) => handleChange(e)} onClick={(e) => {e.preventDefault();if (searchValue === SEARCHDEFAULTVALUE) setSearchValue("")}} value={searchValue}/>
    </form>
    {searchResults}
    </div>;
}

export default SearchBar;