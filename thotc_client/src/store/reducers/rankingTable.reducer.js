import * as Actions from '../actions';

const initialState = {
    responsedata : null
}

const rankingTableReducer = (state=initialState, action) => {
    switch(action.type){
        case Actions.FETCH_RANKINGTABLE_DATA : {
            return {
                ...state,
                responsedata : action.data
            };
        }
        default : {
            return state;
        }
    }
}

export default rankingTableReducer;