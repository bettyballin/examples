
const express = require('express');
const app = express();

// Middleware to block non-localhost connections
app.use((req, res, next) => {
  const ip = req.socket.remoteAddress;
  // Allow localhost requests
  if (ip === '127.0.0.1' || ip === '::1') {
    next();
  } else {
    // Deny requests from other sources
    res.status(403).send('Access denied');
  }
});

// Define your API endpoints here
app.get('/api/some-resource', (req, res) => {
  res.send('This is some resource accessible only from localhost');
});

// Start the server
const PORT = 3000;
app.listen(PORT, 'localhost', () => {
  console.log(`Server running on http://localhost:${PORT}`);
