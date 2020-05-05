import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import * as serviceWorker from "./serviceWorker";

import { ThemeProvider } from "@material-ui/core/styles";
import customTheme from "./styles/theme/thcTheme";

import { createStore,applyMiddleware,compose } from "redux";
import { Provider } from "react-redux";
import rootReducer from "./store/reducers";

import thunk from 'redux-thunk';

const composeEnhancer = window.__REDUX__DEVTOOLS_EXTENSION_COMPOSE || compose;
const store = createStore(rootReducer,composeEnhancer(applyMiddleware(thunk)));

ReactDOM.render(
  <React.StrictMode>
    <ThemeProvider theme={customTheme}>
      <Provider store={store}>
        <App />
      </Provider>
    </ThemeProvider>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
