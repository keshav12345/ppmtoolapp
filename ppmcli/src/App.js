import React from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/layout/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import AddProject from './component/Project/AddProject'

function App() {
  return (
    <Router>
        <div>
    <Header/>
    </div>
    <Route exact path="/dashboard" component={Dashboard}/>
    <Route exact path="/addProject" component={AddProject}/>
    </Router>
      );
}

export default App;
