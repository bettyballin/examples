const express = require('express');
const fetch = require('node-fetch');
const app = express();

app.get('/', (req, res) => {
  res.send(`<html><body>
    <img src="/pixel?some=params" />
  </body></html>`);
});

app.get('/pixel', (req, res) => {
  const params = req.query;
  fetch(`http://googleads.g.doubleclick.net/pagead/viewthroughconversion/12345/?${new URLSearchParams(params).toString()}`)
    .then(response => response.redirected ? response.url : null)
    .then(redirectUrl => res.redirect(redirectUrl));
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});