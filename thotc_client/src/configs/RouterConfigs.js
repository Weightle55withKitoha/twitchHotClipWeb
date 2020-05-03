import React from 'react';
import Test from '../components/Test';


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
    }
];