const express = require('express');

let app = express();

app.use((req, res, next) => {
  // Set the CSP header
  res.setHeader("Content-Security-Policy", "script-src 'self';");

  return next();
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});