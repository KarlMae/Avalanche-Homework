import React, {Component} from 'react';
import Typography from '@material-ui/core/Typography';
import Modal from '@material-ui/core/Modal';
import Button from '@material-ui/core/Button';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { fetchPastCalculations } from '../services/calculatorService'

class HistoryModal extends Component {

  constructor() {
    super();
    this.state = {
      open: false,
      data: []
    }
  }

  fetchData() {
    return fetchPastCalculations();
  };

  async handleOpen() {
    this.setState({
      open: true,
      data: await this.fetchData()
    });
  };

  handleClose() {
    this.setState({
      open: false
    });
  };

  render() {
    return (
      <div>
        <Button onClick={() => this.handleOpen()}>Calculator history</Button>
        <Modal
          aria-labelledby="simple-modal-title"
          aria-describedby="simple-modal-description"
          open={this.state.open}
          onClose={() => this.handleClose()}
        >
          <div className="modal">
            <Typography variant="h6" id="modal-title">
              Calculator history
            </Typography>

            <Paper className="table">
              <Table className="table">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Operation</TableCell>
                    <TableCell align="right">Number 1</TableCell>
                    <TableCell align="right">Number 2</TableCell>
                    <TableCell align="right">Result</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {this.state.data.map(row => (
                    <TableRow key={row.ID}>
                      <TableCell align="center">{row.OPERATION}</TableCell>
                      <TableCell align="right">{row.NUMBER1}</TableCell>
                      <TableCell align="right">{row.NUMBER2}</TableCell>
                      <TableCell align="right">{row.RESULT}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Paper>


          </div>
        </Modal>
      </div>
    );
  }
}

export default HistoryModal;