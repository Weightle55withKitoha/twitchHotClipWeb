import { combineReducers } from "redux";
import searchbar from "./searchbar.reducer";
import rankingTable from "./rankingTable.reducer";
import profile from "./profile.reducer";

const rootReducer = combineReducers({
  searchbar,
  rankingTable,
  profile,
});

export default rootReducer;
