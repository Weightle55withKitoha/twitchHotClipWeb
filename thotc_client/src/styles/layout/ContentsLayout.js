import React from 'react';
import {makeStyles} from '@material-ui/core/styles';

import { BrowserRouter, Route } from "react-router-dom";
import { RouterConfigs } from "../../configs/RouterConfigs";

const useStyles = makeStyles(theme => ({
    root : {
        display : 'flex',
        justifyContent : 'center',
        width : ''
    },
    main : {
        maxWidth : theme.contentsMaxwidth,
        width : '100%',
        backgroundColor : '#5f7a82',
    },
    contents : {
        margin : theme.spacing(3),
    }
}));

const ContentsLayout = () => {
    const classes = useStyles();

    const routeComponents = RouterConfigs.map(
        ({ path, exact, component }, key) => (
          <Route path={path} exact={exact} component={component} key={key} />
        )
      );

    return (
        <div className = {classes.root}>
            <div className = {classes.main}>
               <BrowserRouter>{routeComponents}</BrowserRouter>
            </div>
        </div>
    );
};

export default ContentsLayout;