import React, { useState } from 'react';
import { Card, CardContent, TextField, Typography, Button } from '@material-ui/core';

function IOCard(props) {
    const [input1, setInput1] = useState('');
    const [input2, setInput2] = useState('');
    const [output, setOutput] = useState('');
    const [error, setError] = useState('');

    const handleInput1Change = (event) => {
        const value = event.target.value;
        // Allow only numbers
        if (!isNaN(value)) {
            setInput1(value);
        }
    };
    
    const handleInput2Change = (event) => {
        const value = event.target.value;
        // Allow only numbers
        if (!isNaN(value)) {
            setInput2(value);
        }
    };

    const handleSubmit = async () => {
        if (input1 && input2) {
            try {
                const response = await props.calculationFunction(parseFloat(input1), parseFloat(input2));
                setOutput(response.result);
                setError('');
            } catch (error) {
                console.error('Error:', error);
                setOutput('');
                setError('Error calculating');
            }
        } else {
            setError('Please enter both values');
        }
    };

    const cardStyle = {
        width: '900px',
        maxWidth: '90vw',
        height: 'auto',
        margin: 'auto'
    };

    const inputStyle = {
        paddingRight: '5px',
        paddingLeft: '5px',
        width: '100px'
    };

    const buttonStyle = {
        marginLeft: '10px',
    };

    const flexContainer = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flexWrap: 'wrap'
    };

    const resultStyle = {
        marginTop: '10px',
        textAlign: 'center'
    };

    const cardContents = (
        <CardContent>
            <Typography variant="h5" component="h2">
                {props.name}
            </Typography>
            <div style={flexContainer}>
                {props.displayText.split("|")[0]}
                <TextField 
                    label="X" 
                    variant="outlined" 
                    value={input1} 
                    onChange={handleInput1Change}
                    style={inputStyle}
                />
                {props.displayText.split("|")[1]}
                <TextField 
                    label="Y" 
                    variant="outlined" 
                    value={input2} 
                    onChange={handleInput2Change}
                    style={inputStyle}
                />
                {props.displayText.split("|")[2]}
                <Button 
                    variant="contained" 
                    color="primary" 
                    onClick={handleSubmit}
                    style={buttonStyle}
                >
                    Calculate
                </Button>
            </div>
            {output && (
                <Typography variant="h6" style={resultStyle}>
                    Result: {output}
                </Typography>
            )}
            {error && (
                <Typography variant="h6" style={{ ...resultStyle, color: 'red' }}>
                    {error}
                </Typography>
            )}
        </CardContent>
    );

    return (
        <Card variant='outlined' style={cardStyle}>{cardContents}</Card>
    );
}

export default IOCard;
