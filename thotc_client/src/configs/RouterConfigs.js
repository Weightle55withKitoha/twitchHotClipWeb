import React from "react";
import MainComponent from "../components/Maincomponent";
import Profile from "../components/profiles/Profile";

export const RouterConfigs = [
  {
    path: "/",
    exact: true,
    component: () => <MainComponent />,
  },
  {
    path: "/profile/:username",
    exact: true,
    component: () => <Profile />,
  },
];
