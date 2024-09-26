const express = require('express');
const crypto = require('crypto');
const app = express();

app.use((req, res, next) => {
  const nonce = crypto.randomBytes(16).toString("base64");

  // Store the generated nonce in a session or request object for later use
  req.nonce = nonce;

  res.set({
    "Content-Security-Policy": `script-src 'self' 'nonce-${nonce}'`
  });

  return next();
});

// Example route to test the middleware
app.get('/', (req, res) => {
  res.send(`<script nonce="${req.nonce}">console.log('Hello World!');</script>`);
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});