const express = require('express');
const jwt = require('express-jwt');

const app = express();

const checkJwt = jwt({
  secret: 'your-secret-key',
  algorithms: ['HS256'],
  issuer: 'https://your-domain.com',
  audience: 'https://your-domain.com/api'
});

// This route doesn't need authentication
app.get('/api/public', function(req, res) {
  res.json({
    message: 'Hello from a public endpoint! You don\'t need to be authenticated to see this.'
  });
});

// This route need authentication
app.get('/api/private', checkJwt, function(req, res) {
  res.json({
    message: 'Hello from a private endpoint! You need to be authenticated to see this.'
  });
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});