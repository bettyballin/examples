const express = require('express');
const crypto = require('crypto');
const app = express();

function getNonce() {
  return 'nonce-' + crypto.randomBytes(16).toString('hex');
}

app.use((req, res, next) => {
  const nonceValue = getNonce();

  // Set the CSP header with a unique nonce value
  res.setHeader(`Content-Security-Policy`, `script-src 'self' 'unsafe-eval' ${nonceValue};`);

  next();
});

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});