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
<<<<<<< HEAD
        console.log(response.data);
        dispatch(fetchProfileData(response.data));
      })
      .catch((error) => {
=======
        dispatch(fetchProfileData(response.data));
      })
      .catch((error) => {
        dispatch(fetchProfileData(null));
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
        throw error;
      });
  };
};

export const fetchClipDatas = (clipdatas) => {
  return {
    type: FETCH_CLIP_DATAS,
    clipdatas,
<<<<<<< HEAD
  }
}

export const getClipDatas = (streamerName) => {
  return (dispatch)=> {
    return axios
    .get(`/api/getclips/${streamerName}`)
    .then((response)=>{
      console.log(response.data);
      dispatch(fetchClipDatas(response.data.data));
    })
    .catch((error)=>{
      throw error;
    });
=======
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
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
  };
};
