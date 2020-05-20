import React from "react";
import { Grid } from "@material-ui/core";
import ClipItem from "./ClipItem";

import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    alignItems: "center",
  },
  item: {
    width: "25%",
    minWidth: "300px",
    minHeight: "300px",
    paddingLeft: "15px",
    paddingRight: "15px",
    paddingBottom: "30px",
  },
}));

const ClipComponent = ({ clipDatas, user, name }) => {
  const classes = useStyles();

  return (
    <div>
      <h1>스트리머의 핫클립</h1>
      {/* {JSON.stringify(clipDatas)} */}
      <Grid container direction="row" className={classes.root}>
        {user &&
          clipDatas &&
          clipDatas.map((item, index) => (
            <Grid item className={classes.item} key={index}>
              <ClipItem clipItem={item} user={user} name={name} />
            </Grid>
          ))}
      </Grid>
    </div>
  );
};

export default ClipComponent;
