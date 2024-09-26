const express = require('express');

// Create the app
let app = express();

app.get('/api/local', (req, res) => {
  // Handle local API call
  res.send('Local API call handled');
});

// Bind to localhost
app.listen(3001, 'localhost', () => console.log('Server running on http://localhost:3001'));