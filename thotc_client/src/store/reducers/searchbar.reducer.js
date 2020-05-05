import * as Actions from '../actions';

const initialState = {
    searchText : "",
};

const searchBarReducer = (state=initialState, action) => {
    switch (action.type) {
        case Actions.SET_SEARCH_TEXT : {
            return {
                ...state,
                searchText : action.searchText
            };
        }
        default : {
            return state;
        }
    }
}

export default searchBarReducer;