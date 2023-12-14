const headerStyle = {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%',
    height:'8vh',
    backgroundColor: 'rgb(99, 89, 133)'
}

const titleStyle = {
    fontSize: '3rem',
    color: 'rgb(221, 230, 237)'
}

function HeaderSB() {
    return(
    <header style={headerStyle}>
        <div style={titleStyle}>Switchblade</div>
    </header>
    )
}

export default HeaderSB;
