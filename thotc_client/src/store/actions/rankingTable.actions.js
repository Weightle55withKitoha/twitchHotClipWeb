import axios from 'axios';

export const FETCH_RANKINGTABLE_DATA ="rankingTable/FETCH_RANKINGTABLE_DATA";
export const GET_RANKINGTABLE_DATA = "rankingTable/GET_RANKINGTABLE_DATA";

export const fetchRankingTableData = (data)=> {
    return {
        type : FETCH_RANKINGTABLE_DATA,
        data
    }
}

export const getRankingTableDataAPI= () => {
    const request = axios.get("http://localhost:8080/streams");

    return (dispatch) => {
        return axios.get("http://localhost:8080/streams").then(response=>{
            dispatch(fetchRankingTableData(response.data))
        })
        .catch(error => {
            throw(error);
        });
    }
}
