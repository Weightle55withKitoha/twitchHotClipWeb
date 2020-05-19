import React from "react";
import { Toolbar, Typography } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  bolder: {
    fontWeight: "bolder",
    width : "100%"
  },
}));

const TableToolbar = () => {
  const classes = useStyles();
  return (
    <Toolbar>
      <Typography variant="h5" className={classes.bolder}>
        스트리머 순위
      </Typography>
    </Toolbar>
  );
};

export default TableToolbar;
