import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { AppBar, Toolbar, Typography } from "@material-ui/core";
import { NavbarItems } from '../../configs/NavbarItemConfigs';
import {Link} from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },

  toolbar: {
    justifyContent : 'center',
  },
  contents : {
      justifyContent : 'flex-start',
      width : '100%',
      maxWidth : theme.contentsMaxwidth,
      // backgroundColor : '#756650',
  },
  title: {
    // backgroundColor : '#5f7a82',
    margin : theme.spacing(3)
  },
  mainLogo : {
    margin : theme.spacing(3)
  },
  linkNone : {
    textDecoration : 'none',
  }
}));

const TopNavBar = () => {
  const classes = useStyles();
  return (
    <AppBar position="static">
      <Toolbar className={classes.toolbar}>
          <Toolbar className={classes.contents}>
              <Typography variant ="h5" className={classes.mainLogo}>
                  MainLogo
              </Typography>
          {
              NavbarItems.map((item,index) => (
                <Link to={item.linkto} className={classes.linkNone} >
                  <Typography variant={item.TypoVariant} className={classes.title} key={index}>
                      {item.menuText}
                  </Typography>
                </Link>
              ))
          }
        </Toolbar>
      </Toolbar>
    </AppBar>
  );
};

export default TopNavBar;
