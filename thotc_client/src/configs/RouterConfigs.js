import React from 'react';
import MainComponent from '../components/Maincomponent';


export const RouterConfigs = [
    {
        path : "/",
        exact : true,
        component : () => (<MainComponent/>)
    },
    
];