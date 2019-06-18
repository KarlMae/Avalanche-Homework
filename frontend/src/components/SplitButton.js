import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';

const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  formControl: {
    margin: theme.spacing(3),
  },
  group: {
    margin: theme.spacing(1, 0),
  },
}));

const RadioButtonsGroup = (props) => {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">Operation</FormLabel>
        <RadioGroup
          aria-label="Operation"
          name="operation"
          className={classes.group}
          value={props.value}
          onChange={(event, value) => props.setOperation(value)}
        >
          <FormControlLabel value="sum" control={<Radio />} label="Addition" />
          <FormControlLabel value="sub" control={<Radio />} label="Subtraction" />
          <FormControlLabel value="prod" control={<Radio />} label="Multiplication" />
          <FormControlLabel value="div" control={<Radio />} label="Division" />
        </RadioGroup>
      </FormControl>
    </div>
  );
};

export default RadioButtonsGroup;