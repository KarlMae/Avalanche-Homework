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
import {fetchPastCalculations} from '../../services/calculatorService'
import './HistoryModal.scss';
import { caseString } from '../../util/StringUtil'

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

            <div className="table">
            <Paper>
              {
                this.state.data.length ? (
              <Table>
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Operation</TableCell>
                    <TableCell align="right">Number 1</TableCell>
                    <TableCell align="right">Number 2</TableCell>
                    <TableCell align="right">Result</TableCell>
                  </TableRow>
                </TableHead>
                    <TableBody>
                      { this.state.data.map(row =>
                        <TableRow key={row.id}>
                          <TableCell align="center">{caseString(row.operation)}</TableCell>
                          <TableCell align="right">{row.number1}</TableCell>
                          <TableCell align="right">{row.number2}</TableCell>
                          <TableCell align="right">{row.result}</TableCell>
                        </TableRow>
                      )}
                    </TableBody>
              </Table>
                ) : <h2 className="empty-table-message"> No calculations have been made yet</h2>
              }
            </Paper>
            </div>
          </div>
        </Modal>
      </div>
    );
  }
}

export default HistoryModal;