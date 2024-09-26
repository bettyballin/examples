import React from 'react';
import ReactDOM from 'react-dom';

// Import initial state object passed down by Jinja2 template engine during SSR.
const initialState = JSON.parse(document.getElementById('initial-state').textContent);

function App() {
  // Use `initialState` to initialize component's props or state as needed...
  return <div>Hello World!</div>;
}

ReactDOM.hydrate(
  <App />,
  document.getElementById('root')
);