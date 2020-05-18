import React from "react";
import * as Actions from "../store/actions";
import { useDispatch, useSelector } from "react-redux";
import {
  Paper,
  Grid,
  FormControl,
  InputAdornment,
  OutlinedInput,
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import SearchIcon from "@material-ui/icons/Search";
import clsx from "clsx";
import { withRouter } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    marginTop: 30,
  },
  explain: {
    marginTop: 10,
  },
  margin: {},
  withoutLabel: {},
  textField: {
    width: "75ch",
    minWidth: "50ch",
  },
  span: {
    color: "#a2a8b3",
  },
}));

const SearchBar = (props) => {
  const dispatch = useDispatch();
  const searchText = useSelector((state) => state.searchbar.searchText);

  const handleChange = (e) => {
    return dispatch(Actions.setSearchBarText(e));
  };
  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      props.history.push("/profile/" + searchText);
    }
  };
  const classes = useStyles();
  return (
    <div>
      <Grid container justify="center">
        <Grid item>
          <Paper className={classes.root} elevation={10}>
            <FormControl
              className={clsx(classes.margin, classes.textField)}
              variant="outlined"
            >
              <OutlinedInput
                id="outlined-adornment-weight"
                value={searchText}
                onChange={handleChange}
                onKeyPress={(e) => handleKeyDown(e)}
                startAdornment={
                  <InputAdornment position="start">
                    <SearchIcon />
                  </InputAdornment>
                }
                aria-describedby="outlined-weight-helper-text"
                inputProps={{
                  "aria-label": "weight",
                }}
                labelWidth={0}
                placeholder={"스트리머 검색"}
                fullWidth={true}
              />
            </FormControl>
          </Paper>
        </Grid>
        <Grid container justify="center">
          <Grid item className={classes.explain}>
            <span className={classes.span}>
              시청자가 25명 이상인 스트리머가 자동으로 등록됩니다.
            </span>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

export default withRouter(SearchBar);
