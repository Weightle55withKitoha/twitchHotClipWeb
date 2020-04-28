import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import { mainContents } from '../../configs/ContentsLayoutConfigs';

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
    return (
        <div className = {classes.root}>
            <div className = {classes.main}>
                {mainContents.map( (item,index) => (<div className={classes.contents} key={index}>{item}</div>))}
            </div>
        </div>
    );
};

export default ContentsLayout;