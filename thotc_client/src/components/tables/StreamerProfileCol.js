import React from "react";
import {Link} from 'react-router-dom';
import { Grid, Avatar } from "@material-ui/core";

const StreamerProfileCol = ({ ImgUrl, StreamerName }) => {
  return (
    <Link to={`/profile/${StreamerName}`} style={{textDecoration:'none',color : '#000000'}}>
    <Grid container alignItems="flex-start" >
      <Grid item>
        <Avatar alt={StreamerName} src={ImgUrl} />
      </Grid>
      <Grid item style={{marginTop:"10px",marginLeft:"10px",fontWeight:"bold"}}>{StreamerName}</Grid>
    </Grid>
    </Link>
  );
};

export default StreamerProfileCol;
