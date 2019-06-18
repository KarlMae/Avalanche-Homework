import React, {Component} from 'react'
import CalculatorForm from '../../components/CalculatorForm';
import {Container} from '@material-ui/core';

class HomePage extends Component {

  render() {
    return (
      <div>
        <header className="App-header">
          <img src="https://partnerweb.ee/wp-content/uploads/2018/08/avalanche-laboratory-ou-logo-r.png"
               alt="logo"
               className="logo"/>
          <h3>
            Avalanche homework
          </h3>
        </header>

        <Container className="page-container">
          <CalculatorForm/>
        </Container>
      </div>
    )
  }
}

export default HomePage