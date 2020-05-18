import React, { useEffect } from "react";
import {
  Grid,
  Container,
  makeStyles,
  ListItemText,
  ListItem,
  List,
  Avatar,
  Box,
  Typography,
  Paper,
} from "@material-ui/core";
import * as Actions from "../../store/actions";
import { useDispatch, useSelector } from "react-redux";
import { withRouter } from "react-router-dom";
import ClipComponent from "./ClipComponent";
import ProfileErrorPage from "./ProfileErrorPage";

const useStyles = makeStyles((theme) => ({
  root: {
    width: "100%",
    maxWidth: 360,
    marginTop: "1rem",
  },
  image: {
    width: "17rem",
    height: "18rem",
    backgroundColor: "#ffffff",
    marginTop: "3rem",
    borderRadius: "20px",
  },
  item: {
    padding: 0,
  },
  paperStyle: {
    width: "1000px",
    height: "25rem",
    backgroundColor: "#000000",
  },
}));

const Profile = ({ match }) => {
  const dispatch = useDispatch();
  const userInfo = useSelector((state) => state.profile.responsedata);
  const name = match.params.username;
  const clipDatas = useSelector((state) => state.profile.clipdatas);

  const classes = useStyles();

  useEffect(() => {
    dispatch(Actions.getProfileData(name));
    dispatch(Actions.getClipDatas(name));
    // eslint-disable-next-line
  }, []);

  let table;

  if (userInfo != null) {
    table = (
      <Grid container>
        <Grid item>
          <Paper square={false} elevation={3}>
            <Avatar
              className={classes.image}
              variant="rounded"
              src={userInfo.streamerImgUrl}
              alt={userInfo.streamerName}
            ></Avatar>
          </Paper>
          <Typography style={{ marginTop: "2rem" }} variant="h3">
            {userInfo.streamerName}
          </Typography>
          <List className={classes.root} disablePadding={false}>
            <ListItem classes={{ root: classes.item }}>
              <Box
                style={{
                  backgroundColor: "#e53e3e",
                  width: "0.25rem",
                  height: "1.5rem",
                  marginRight: "0.5rem",
                }}
              ></Box>
              <ListItemText primary="평청자"></ListItemText>
              <ListItemText
                primary={userInfo.viewerAverage}
                style={{
                  marginLeft: "0.1rem",
                  color: "#e53e3e",
                  fontWeight: "bold",
                }}
              ></ListItemText>
            </ListItem>
            <ListItem classes={{ root: classes.item }}>
              <Box
                style={{
                  backgroundColor: "#d69e2e",
                  width: "0.25rem",
                  height: "1.5rem",
                  marginRight: "0.5rem",
                }}
              ></Box>
              <ListItemText primary="팔로워"></ListItemText>
              <ListItemText
                primary={userInfo.followerCount}
                style={{
                  marginLeft: "0.1rem",
                  color: "#d69e2e",
                  fontWeight: "bold",
                }}
              ></ListItemText>
            </ListItem>
            <ListItem classes={{ root: classes.item }}>
              <Box
                style={{
                  backgroundColor: "#805ad5",
                  width: "0.25rem",
                  height: "1.5rem",
                  marginRight: "0.5rem",
                }}
              ></Box>
              <ListItemText primary="방송량"></ListItemText>
              <ListItemText
                primary={userInfo.broadcastTime}
                style={{
                  marginLeft: "0.1rem",
                  color: "#805ad5",
                  fontWeight: "bold",
                }}
              ></ListItemText>
            </ListItem>
            <ListItem classes={{ root: classes.item }}>
              <Box
                style={{
                  backgroundColor: "#dd6b20",
                  width: "0.25rem",
                  height: "1.5rem",
                  marginRight: "0.5rem",
                }}
              ></Box>
              <ListItemText primary="방송시간대"></ListItemText>
            </ListItem>
          </List>
        </Grid>
      </Grid>
    );
  } else {
    return <ProfileErrorPage></ProfileErrorPage>;
  }
  return (
    <Container maxWidth="lg" style={{ background: "#e2e8f0" }}>
      {table}
      <ClipComponent clipDatas={clipDatas} user={userInfo} name={name} />
    </Container>
  );
};

export default withRouter(Profile);
