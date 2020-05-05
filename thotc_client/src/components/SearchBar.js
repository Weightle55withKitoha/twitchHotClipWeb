import React from 'react';
import * as Actions from '../store/actions';
import {useDispatch,useSelector} from 'react-redux';

const SearchBar = () => {

    const dispatch = useDispatch();
    const searchText = useSelector(state => state.searchbar.searchText);

    return (<div>{searchText}</div>);
}

export default SearchBar;