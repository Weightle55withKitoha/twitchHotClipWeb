import React from 'react';
import MainComponent from '../components/Maincomponent';
import SearchBar from '../components/SearchBar';

export const RouterConfigs = [
    {
        path : "/",
        exact : true,
        component : () => (<MainComponent/>)
    },
    {
        path : "/test",
        exact : false,
        component : () => <SearchBar/>
    }
    
];