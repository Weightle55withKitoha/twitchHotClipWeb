import React from "react";
import MainLayout from "./styles/layout/MainLayout";
import { makeStyles } from "@material-ui/core/styles";

import { BrowserRouter } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    position: "absolute",
    width: "100%",
    height: "auto",
    minHeight: "100%",
    backgroundColor: "#dae0e8",
    overflowY: "visible",
  },
}));

const App = () => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <BrowserRouter>
        <MainLayout />
      </BrowserRouter>
    </div>
  );
};

export default App;
