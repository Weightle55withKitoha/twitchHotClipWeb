import React from "react";
import MainLayout from "./styles/layout/MainLayout";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  root: { position: "absolute", width: "100%", height: "100%", backgroundColor:'#dae0e8' },
}));

const App = () => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <MainLayout />
    </div>
  );
};

export default App;
