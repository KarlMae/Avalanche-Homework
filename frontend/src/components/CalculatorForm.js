import React, {Component} from 'react'
import Button from '@material-ui/core/Button';
import SplitButton from './SplitButton';
import OutlinedInputAdornments from './TextField';
import {postCalculation} from '../services/calculatorService'


class CalculatorForm extends Component {

  constructor(props) {
    super(props);
    this.state = {
      number1: "",
      number2: "",
      result: "",
      operation: 'sum'
    };

    this.calculate = this.calculate.bind(this);
  }

  setNumber(event, field) {
    const prevState = this.state;
    prevState[field] = parseFloat(event.target.value) || "";

    this.setState(prevState)
  }

  setOperation(operation) {
    this.setState({
      operation: operation
    })
  }

  async calculate() {
    this.setState({
      result: await postCalculation(
        {
          op: this.state.operation,
          num1: this.state.number1,
          num2: this.state.number2
        }
      )
    })
  }

  render() {
    return (
      <div className="calculator">
        <h1>Calculator</h1>

        <div className="calculator-form">
          <div className="input-fields">
            <OutlinedInputAdornments
              label="Number 1"
              controlName="number1"
              setNumber={(event, field) => this.setNumber(event, field)}
              value={this.state.number1}
            />
            <OutlinedInputAdornments
              label="Number 2"
              controlName="number2"
              value={this.state.number2}
              setNumber={(event, field) => this.setNumber(event, field)}
            />
            <OutlinedInputAdornments
              label="Output"
              value={this.state.result}
              disabled
            />
          </div>
          <SplitButton
            value={this.state.operation}
            setOperation={(operation) => this.setOperation(operation)}
          />
        </div>

        <div className="calculator-buttons">
          <Button variant="contained" color="primary" onClick={() => this.calculate()}>
            Calculate!
          </Button>

          <Button size="large">
            Result history
          </Button>
        </div>
      </div>
    )
  }
}

export default CalculatorForm