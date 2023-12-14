import './App.css';
import Card from './components/Card';
import MainScreen from './pages/MainScreen';
import Calculators from './pages/Calculators';
import { BrowserRouter as Router, Route, Routes, Switch } from 'react-router-dom'

function App() {
  return (
    <Router>
      <div className='App'>
        <div className='content'></div>
        <Switch>
          <Route exact path='/'>
            <MainScreen/>
          </Route>
          <Route path='/calculators'>
            <Calculators/>
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
