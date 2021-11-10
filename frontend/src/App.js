import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import Home from './pages/Home';
import Index from './pages/Index';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/index" component={Index} />
        {/* <Route path="/show" component={Show} />
        <Route path="/create" component={Create} />
        <Route path="/update" component={Update} />
        <Route path="/delete" component={Delete} />
        <Route component={NotFound} />         */}
      </Switch>
    </Router>
  );
}

export default App;
