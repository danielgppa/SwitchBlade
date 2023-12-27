import './App.css';
import MainScreen from './pages/MainScreen';
import Calculators from './pages/Calculators';
import Generators from './pages/Generators';
import NotFound from './pages/NotFound';
import HeaderSB from './components/HeaderSB';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import Percentage from './pages/Percentage';

function App() {
  return (
    <Router>
      <HeaderSB />
      <div className='App'>
        <div className='content'>
          <Switch>
            <Route exact path='/' component={MainScreen} />
            <Route exact path='/calc/percentage' component={Percentage} />
            <Route exact path='/calc' component={Calculators} />
            
            <Route exact path='/gen' component={Generators} />
            <Route exact path='/404' component={NotFound} />
            <Redirect from='*' to='/404' />
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;
