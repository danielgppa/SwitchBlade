import { IconButton } from '@material-ui/core';
import { Avatar } from '@material-ui/core';
import { useHistory } from 'react-router-dom'

const headerStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    position: 'relative',
    width: '100%',
    height: '8vh',
    backgroundColor: 'rgb(99, 89, 133)'
};

const titleStyle = {
    fontSize: '3rem',
    color: 'rgb(221, 230, 237)'
};

const iconButtonStyle = {
    position: 'absolute',
    left: 0,
    top: '50%',
    transform: 'translateY(-50%)'
};

function HeaderSB() {
    let history = useHistory();

    const handleClick = () => {
        history.push('/');
    }

    return (
        <header style={headerStyle}>
            <IconButton aria-label='home' onClick={handleClick} style={iconButtonStyle}>
                <Avatar src={"https://www.svgrepo.com/show/96177/home-button.svg"}/>
            </IconButton>
            <div style={titleStyle}>Switchblade</div>
        </header>
    )
}

export default HeaderSB;
