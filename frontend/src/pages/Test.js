import React, { useState } from 'react';
import { whatIsThePercentageOf } from '../api/apiFetch'; // Replace with the path to your API file

function PercentageCalculator() {
  const [value1, setValue1] = useState('');
  const [value2, setValue2] = useState('');
  const [result, setResult] = useState(null);
  const [error, setError] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!value1 || !value2) {
      setError('Please enter both values.');
      return;
    }
  
    try {
      const response = await whatIsThePercentageOf(value1, value2);
      setResult(response.result); // Only set the result field
      setError('');
    } catch (err) {
      setError('An error occurred while calculating.');
      console.error(err);
    }
  };

  return (
    <div>
      <h2>What is the Percentage Of</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Value 1:
            <input
              type="number"
              value={value1}
              onChange={(e) => setValue1(e.target.value)}
            />
          </label>
        </div>
        <div>
          <label>
            Value 2:
            <input
              type="number"
              value={value2}
              onChange={(e) => setValue2(e.target.value)}
            />
          </label>
        </div>
        <button type="submit">Calculate</button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {result !== null && <p>Result: {result}</p>}
    </div>
  );
}

export default PercentageCalculator;