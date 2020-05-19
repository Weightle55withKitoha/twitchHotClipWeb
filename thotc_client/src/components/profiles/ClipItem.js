import React from "react";
import {
  Grid,
  Card,
  CardMedia,
  Avatar,
  CardActionArea,
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    height: "270px",
  },
  image: {
    width: "100%",
    maxHeight: "50%",
  },
  avatar: {
    width: "25%",
    paddingLeft: "9px",
    paddingTop: "9px",
  },
  description: {
    width: "75%",
    paddingTop: "9px",
    paddingLeft: "4px",
  },
  title: {
    display: "flex",
    height: "60px",
    overflow: "hidden",
    fontWeight: "bolder",
    fontSize: "medium",
  },
  viewc: {
    display: "flex",
    height: "25%",
    color: "#ababab",
    fontSize: "small",
  },
  date: {
    display: "flex",
    height: "25%",
    color: "#ababab",
    fontSize: "small",
  },
}));

const ClipItem = ({ clipItem, user, name }) => {
  const classes = useStyles();

  const createdAt = clipItem.created_at;
  const createdSplit = createdAt.split("T");
  const uploadDate = createdSplit[0];
  const tsplit = createdSplit[1].split("Z");
  const uploadTime = tsplit[0];

  const onClickHandler = (link) => {
    console.log("onclick");
    return window.open(link,"_blank");
  };

  return (
    <Card variant="elevation" className={classes.root}>
      <CardActionArea onClick={()=>onClickHandler(clipItem.url)}>
      <Grid container direction="column">
        <Grid item>
          <Grid item className={classes.image}>
            <CardMedia component="img" src={clipItem.thumbnail_url} />
            {/* <CardMedia component="video" src={clipItem.url} /> */}
          </Grid>
          <Grid container direction="row">
            <Grid item className={classes.avatar}>
              <Avatar alt="testalt" src={user.streamerImgUrl} />
              {name}
            </Grid>
            <Grid item className={classes.description}>
              <Grid container direction="column">
                <Grid item className={classes.title}>
                  {clipItem.title}
                </Grid>
                <Grid item className={classes.viewc}>
                  조회수 : {clipItem.view_count}회
                </Grid>
                <Grid item className={classes.date}>
                  업로드 : {uploadDate} {uploadTime}
                </Grid>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
      </CardActionArea>
    </Card>
  );
};

export default ClipItem;
