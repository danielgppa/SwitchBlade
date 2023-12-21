import { useState } from 'react';
import { Card, CardContent, TextField, Typography, InputAdornment } from '@material-ui/core';
import { whatIsThePercentageOf } from '../api/apiFetch';

function IOCard() {
    const [input1, setInput1] = useState('');
    const [input2, setInput2] = useState('');
    const [output, setOutput] = useState('');

    const handleInput1Change = (event) => {
        setInput1(event.target.value);
        updateOutput(event.target.value, input2);
    };

    const handleInput2Change = (event) => {
        setInput2(event.target.value);
        updateOutput(input1, event.target.value);
    };

    const updateOutput = async (val1, val2) => {
        if (val1 && val2) {
            try {
                const response = await whatIsThePercentageOf(parseFloat(val1), parseFloat(val2));
                setOutput(response.result); // Update to set only the result
            } catch (error) {
                console.error('Error:', error);
                setOutput('Error'); // Display error in output field
            }
        } else {
            setOutput(''); // Clear output if any of the inputs are empty
        }
    };

    const cardStyle = {
        width: '900px',
        maxWidth: '90vw',
        height: '15vh',
        margin: 'auto'
    };

    const inputStyle = {
        paddingRight: '5px',
        paddingLeft: '5px',
        width: '100px'
    };

    const outputStyle = {
        width: '150px',
        paddingLeft: '5px'
    };

    const flexContainer = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
    };

    const cardContents = (
        <CardContent>
            <Typography variant="h5" component="h2">
                Percentage Calculator
            </Typography>
            <div style={flexContainer}>
                <TextField 
                    label="X" 
                    variant="outlined" 
                    value={input1} 
                    onChange={handleInput1Change}
                    style={inputStyle}
                    InputProps={{endAdornment: <InputAdornment position="end">%</InputAdornment>}}
                />
                of
                <TextField 
                    label="Y" 
                    variant="outlined" 
                    value={input2} 
                    onChange={handleInput2Change}
                    style={inputStyle}
                />
                is
                <TextField 
                    label="Result" 
                    variant="outlined" 
                    value={output} 
                    disabled
                    style={outputStyle} 
                />
            </div>
        </CardContent>
    );
    return (
        <Card variant='outlined' style={cardStyle}>{cardContents}</Card>
    );
}

export default IOCard;
