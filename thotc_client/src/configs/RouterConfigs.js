import React from 'react';
import Test from '../components/Test';
import Testtwo from '../components/Testtwo';
import MainComponent from '../components/Maincomponent';


export const RouterConfigs = [
    {
        path : "/",
        exact : true,
        component : () => (<MainComponent/>)
    },
    {
        path : "/test",
        exact : false,
        component : () => (<Test/>)
    },
    {
        path : "/test2",
        exact : false,
        component : () => (<Testtwo/>)
    }
];