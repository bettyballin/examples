jsx
import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import PrivateRoute from './PrivateRoute';
import LoginPage from './LoginPage';
import HomePage from './HomePage';
import AccountPage from './AccountPage';
import appStore from './appStore';

ReactDOM.render(
  <Provider store={appStore}>
    <BrowserRouter>
      <Switch>
        <Route path="/login" component={LoginPage} />
        <PrivateRoute path="/analytics" component={HomePage} />
        <PrivateRoute path="/account" component={AccountPage} />
      </Switch>
    </BrowserRouter>
  </Provider>,
  document.getElementById('root')
);