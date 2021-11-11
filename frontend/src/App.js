import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import Home from './pages/Home';
import Index from './pages/Index';
import Show from './pages/Show';
import Create from './pages/Create';
import Update from './pages/Update';
import Delete from './pages/Delete';
import NotFound from './pages/NotFound';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/index" component={Index} />
        <Route path="/show" component={Show} />
        <Route path="/create" component={Create} />
        <Route path="/update" component={Update} />
        <Route path="/delete" component={Delete} />
        <Route path="*" component={NotFound} />        
      </Switch>
    </Router>
  );
}

export default App;
