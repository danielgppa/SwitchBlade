const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    height: '92vh'
};

const style404 = {
    fontSize: '4rem',
    color: 'rgb(221, 230, 237)'
};

const styleNotFound = {
    fontSize: '2rem',
    color: 'rgb(221, 230, 237)'
};

function NotFound() {
    return (
        <div style={containerStyle}>
            <div style={style404}>404</div>
            <div style={styleNotFound}>Page not found.</div>
        </div>
    );
}

export default NotFound;
