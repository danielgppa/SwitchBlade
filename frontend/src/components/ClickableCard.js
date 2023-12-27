import React from 'react';
import { useHistory } from 'react-router-dom';

function ClickableCard(props) {
  const history = useHistory();

  const navigateTo = () => {
    history.push(props.route);
  };

  const cardStyle = {
    border: '1px solid black',
    padding: '20px',
    margin: '10px',
    width: '300px',
    textAlign: 'center',
    cursor: 'pointer',
    display: 'inline-block',
    borderRadius: '5px',
    backgroundColor: 'white',
    color: 'black'
  };

  return (
    <div style={cardStyle} onClick={navigateTo}>
      <h2>{props.name}</h2>
    </div>
  );
}

export default ClickableCard;
