import React from 'react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  margin: {
    margin: theme.spacing(1),
  },
  textField: {
    flexBasis: 200,
  },
}));

const OutlinedInput = (props) => {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <TextField
        id="outlined-simple-start-adornment"
        className={clsx(classes.margin, classes.textField)}
        onChange={(event) => props.setNumber(event, props.controlName)}
        value={props.value}
        variant="outlined"
        label={props.label}
        disabled={props.disabled || false}
      />
    </div>
  );
};

export default OutlinedInput;