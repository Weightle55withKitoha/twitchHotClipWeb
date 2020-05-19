import React from 'react';
import RankingTable from './tables/RankingTable';
import SearchBar from './SearchBar';
import {makeStyles} from '@material-ui/core/styles';

const useStyles = makeStyles(theme=>({
  root : {
    content : 'relative'
  }
}));

const MainComponent = () => {
    const classes = useStyles();
    return (<div className={classes.root}>
        <SearchBar/>
        <RankingTable/>
    </div>);
};

export default MainComponent;