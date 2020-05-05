import React from "react";

import { Grid, Avatar } from "@material-ui/core";

const StreamerProfileCol = ({ ImgUrl, StreamerName }) => {
  return (
    <Grid container alignItems="flex-start">
      <Grid item>
        <Avatar alt={StreamerName} src={ImgUrl} />
      </Grid>
      <Grid item style={{marginTop:"10px",marginLeft:"10px",fontWeight:"bold"}}>{StreamerName}</Grid>
    </Grid>
  );
};

export default StreamerProfileCol;
