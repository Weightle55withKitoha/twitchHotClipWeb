import React from 'react';
import Test from '../components/Test';
import Testtwo from '../components/Testtwo';


export const RouterConfigs = [
    {
        path : "/",
        exact : true,
        component : () => (<Test/>)
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