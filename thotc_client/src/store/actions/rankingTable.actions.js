import axios from "axios";

export const FETCH_RANKINGTABLE_DATA = "rankingTable/FETCH_RANKINGTABLE_DATA";
export const GET_RANKINGTABLE_DATA = "rankingTable/GET_RANKINGTABLE_DATA";

export const fetchRankingTableData = (data) => {
  return {
    type: FETCH_RANKINGTABLE_DATA,
    data,
  };
};

export const getRankingTableDataAPI = () => {
  return (dispatch) => {
    return axios
      .get(`/api/streams`)
      .then((response) => {
        dispatch(fetchRankingTableData(response.data));
      })
      .catch((error) => {
        throw error;
      });
  };
};
