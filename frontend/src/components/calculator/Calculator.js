import React, {Component} from 'react'
import Button from '@material-ui/core/Button';
import RadioButtonsGroup from '../material/RadioButtonsGroup';
import OutlinedInput from '../material/OutlinedInput';
import {postCalculation} from '../../services/calculatorService'
import HistoryModal from '../material/HistoryModal';
import './Calculator.scss';

class Calculator extends Component {

  constructor(props) {
    super(props);
    this.state = {
      number1: "",
      number2: "",
      result: "",
      operation: 'sum',
      error: false,
      calculationProcessed: false
    };

    this.calculate = this.calculate.bind(this);
    this.validateInput = this.validateInput.bind(this);
  }

  setNumber(event, field) {
    const prevState = this.state;
    prevState[field] = event.target.value;
    prevState['error'] = false;
    prevState['calculationProcessed'] = false;

    this.setState(prevState);
  }

  setOperation(operation) {
    this.setState({
      operation: operation,
      calculationProcessed: false,
    })
  }

  async calculate() {
    await this.validateInput();

    if (this.state.calculationProcessed || this.state.error) {
      return;
    }

    this.setState({
      calculationProcessed: true,
      result: await postCalculation(
        {
          op: this.state.operation,
          num1: this.state.number1,
          num2: this.state.number2
        }
      ),
    })
  }

  validateInput() {
    if (this.state.number1 === "" || this.state.number2 === "") {
      this.setState({error: "Both values must be filled in!"});
    } else if (isNaN(this.state.number1) || isNaN(this.state.number2)) {
      this.setState({error: "Both values must be valid numbers!"});
    }
  }

  render() {
    return (
      <div className="calculator">
        <h1>Calculator</h1>

        <div className="calculator-form">
          <div className="input-fields">
            <OutlinedInput
              id="number1"
              label="Number 1"
              controlName="number1"
              setNumber={(event, field) => this.setNumber(event, field)}
              value={this.state.number1}
            />
            <OutlinedInput
              id="number2"
              label="Number 2"
              controlName="number2"
              value={this.state.number2}
              setNumber={(event, field) => this.setNumber(event, field)}
            />
            <OutlinedInput
              id="output"
              label="Output"
              value={this.state.result}
              disabled
            />
          </div>

          <RadioButtonsGroup
            value={this.state.operation}
            setOperation={(operation) => this.setOperation(operation)}
          />

        </div>

        {this.state.error && (<h3 className="error-message">{this.state.error}</h3>)}

        <div className="calculator-buttons">
          <Button
            className="action-button"
            variant="contained"
            color="primary"
            onClick={() => this.calculate()}
          >
            Calculate
          </Button>

          <HistoryModal/>
        </div>
      </div>
    )
  }
}

export default Calculator