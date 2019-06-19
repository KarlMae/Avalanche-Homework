import React, {Component} from 'react'
import Calculator from '../../components/calculator/Calculator';
import {Container} from '@material-ui/core';
import './HomePage.scss';

class HomePage extends Component {

  render() {
    return (
      <div>
        <header className="header">
          <img src="https://partnerweb.ee/wp-content/uploads/2018/08/avalanche-laboratory-ou-logo-r.png"
               alt="logo"
               className="logo"/>
          <h3>
            Avalanche homework
          </h3>
        </header>

        <Container>
          <Calculator/>
        </Container>
      </div>
    )
  }
}

export default HomePage