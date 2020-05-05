import React from 'react';
import RankingTable from './tables/RankingTable';
import SearchBar from './SearchBar';

const MainComponent = () => {
    return (<div>
        <SearchBar/>
        <RankingTable/>
    </div>);
};

export default MainComponent;