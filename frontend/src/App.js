import React from 'react';
import './App.css';
import HomePage from './pages/HomePage/HomePage';
import {CssBaseline} from '@material-ui/core';
import {theme} from './style/theme'
import {MuiThemeProvider} from '@material-ui/core/styles';

function App() {
  require('dotenv').config();

  return (
    <div className="App">
      <MuiThemeProvider theme={theme}>
        <CssBaseline>
          <HomePage/>
        </CssBaseline>
      </MuiThemeProvider>
    </div>
  );
}

export default App;
