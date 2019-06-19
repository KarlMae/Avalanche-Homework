import React, {Component} from 'react'
import Button from '@material-ui/core/Button';
import SplitButton from './RadioButtonsGroup';
import OutlinedInput from './OutlinedInput';
import {postCalculation} from '../services/calculatorService'
import HistoryModal from './HistoryModal';

class CalculatorForm extends Component {

  constructor(props) {
    super(props);
    this.state = {
      number1: "",
      number2: "",
      result: "",
      operation: 'sum',
      showError: false
    };

    this.calculate = this.calculate.bind(this);
  }

  setNumber(event, field) {
    const prevState = this.state;
    prevState[field] = parseFloat(event.target.value) || "";

    this.setState(prevState);

    if (this.state.number1 !== "" && this.state.number2 !== "") {
      this.setState({ showError: false });
    }
  }

  setOperation(operation) {
    this.setState({
      operation: operation
    })
  }

  async calculate() {
    if (this.state.number1 === "" || this.state.number2 === "") {
      this.setState({ showError: true });
      return;
    }

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
            <OutlinedInput
              label="Number 1"
              controlName="number1"
              setNumber={(event, field) => this.setNumber(event, field)}
              value={this.state.number1}
            />
            <OutlinedInput
              label="Number 2"
              controlName="number2"
              value={this.state.number2}
              setNumber={(event, field) => this.setNumber(event, field)}
            />
            <OutlinedInput
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

        {this.state.showError && (<h3 className="error-message">Both values must be filled in!</h3>)}

        <div className="calculator-buttons">
          <Button variant="contained" color="primary" onClick={() => this.calculate()}>
            Calculate
          </Button>

          <HistoryModal/>
        </div>
      </div>
    )
  }
}

export default CalculatorForm