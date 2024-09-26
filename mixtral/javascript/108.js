import React from 'react';
import ReactDOM from 'react-dom';

const rootElement = document.getElementById('root');

const initialData = JSON.parse(rootElement.dataset.initial);

function App({ initialData }) {
  // Use the data in your component
  return <div>Initial Data: {JSON.stringify(initialData)}</div>;
}

ReactDOM.render(
  <React.StrictMode>
    <App initialData={initialData} />
  </React.StrictMode>,
  rootElement
);