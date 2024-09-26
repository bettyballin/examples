// Assuming disconnect is a function, define it
function disconnect() {
  console.log("Disconnected");
}

// Import necessary libraries
import React from 'react';
import ReactDOM from 'react-dom';

// Define the App component
function App() {
  return <div>Hello World!</div>;
}

// Execute the code
disconnect();
ReactDOM.render(<App />, document.getElementById('root'));