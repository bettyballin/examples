import React from 'react';
import ReactDOM from 'react-dom';
import './disableReactDevTools';
import App from './App';

const rootElement = document.getElementById('root');

if (process.env.NODE_ENV === 'production') {
  if (typeof window !== 'undefined' && window.__REACT_DEVTOOLS_GLOBAL_HOOK__) {
    window.__REACT_DEVTOOLS_GLOBAL_HOOK__.inject = () => {};
  }
}

ReactDOM.render(<App />, rootElement);