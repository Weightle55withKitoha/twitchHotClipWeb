import * as Actions from "../actions";

const initialState = {
  responsedata: null,
};

const profileReducer = (state = initialState, action) => {
  switch (action.type) {
    case Actions.FETCH_PROFILE_DATA: {
      return {
        ...state,
        responsedata: action.data,
      };
    }
    default: {
      return state;
    }
  }
};

export default profileReducer;
