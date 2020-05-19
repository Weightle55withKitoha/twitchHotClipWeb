import * as Actions from "../actions";

const initialState = {
  responsedata: null,
  clipdatas : null ,
};

const profileReducer = (state = initialState, action) => {
  switch (action.type) {
    case Actions.FETCH_PROFILE_DATA: {
      return {
        ...state,
        responsedata: action.data,
      };
    }
    case Actions.FETCH_CLIP_DATAS : {
      return {
        ...state,
        clipdatas : action.clipdatas,
      }
    }
    default: {
      return state;
    }
  }
};

export default profileReducer;
