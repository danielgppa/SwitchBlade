import './App.css';
import Card from './components/Card';
import MainScreen from './pages/MainScreen';
import Calculators from './pages/Calculators';
import Generators from './pages/Generators';
import NotFound from './pages/NotFound';
import HeaderSB from './components/HeaderSB';
import Test from './pages/Test';
import { BrowserRouter as Router, Route, Routes, Switch, Redirect } from 'react-router-dom'

function App() {
  return (
    <Router>
      <HeaderSB />
      <div className='App'>
        <div className='content'></div>
        <Switch>
          <Route exact path='/' component={MainScreen} />
          <Route path='/calculators' component={Calculators} />
          <Route path='/generators' component={Generators} />
          <Route path='/test' component={Test} />
          <Route path='/404' component={NotFound} />
          <Redirect from='*' to='/404' />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
