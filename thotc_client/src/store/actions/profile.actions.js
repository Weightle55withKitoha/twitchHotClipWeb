import axios from "axios";

export const FETCH_PROFILE_DATA = "profile/FETCH_PROFILE_DATA";
export const GET_PROFILE_DATA = "profile/GET_PROFILE_DATA";
export const FETCH_CLIP_DATAS = "profile/FETCH_CLIP_DATAS";
export const GET_CLIP_DATAS = "profile/GET_CLIP_DATAS";

export const fetchProfileData = (data) => {
  return {
    type: FETCH_PROFILE_DATA,
    data,
  };
};

export const getProfileData = (name) => {
  return (dispatch) => {
    return axios
      .get(`/api/profile/${name}`)
      .then((response) => {
        dispatch(fetchProfileData(response.data));
      })
      .catch((error) => {
        dispatch(fetchProfileData(null));
        throw error;
      });
  };
};

export const fetchClipDatas = (clipdatas) => {
  return {
    type: FETCH_CLIP_DATAS,
    clipdatas,
  };
};

export const getClipDatas = (streamerName) => {
  return (dispatch) => {
    return axios
      .get(`/api/getclips/${streamerName}`)
      .then((response) => {
        dispatch(fetchClipDatas(response.data.data));
      })
      .catch((error) => {
        throw error;
      });
  };
};
