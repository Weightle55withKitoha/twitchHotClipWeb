import axios from "axios";

export const FETCH_PROFILE_DATA = "profile/FETCH_PROFILE_DATA";
export const GET_PROFILE_DATA = "profile/GET_PROFILE_DATA";

export const fetchProfileData = (data) => {
  return {
    type: FETCH_PROFILE_DATA,
    data,
  };
};

export const getProfileData = (name) => {
  return (dispatch) => {
    return axios
      .get(`http://localhost:8080/api/profile/${name}`)
      .then((response) => {
        console.log(response.data);
        dispatch(fetchProfileData(response.data));
      })
      .catch((error) => {
        throw error;
      });
  };
};
