import {combineReducers} from 'redux';
import searchbar from './searchbar.reducer';
import rankingTable from './rankingTable.reducer';

const rootReducer = combineReducers({
    searchbar,
    rankingTable
});

export default rootReducer;
