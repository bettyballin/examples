const express = require('express');
const app = express();

const enforceHTTPS = (req, res, next) => {
  if (!req.secure && req.get('x-forwarded-proto') !== 'https') {
    return res.redirect(`https://${req.headers.host}${req.url}`);
  }

  next();
};

app.use(enforceHTTPS);

app.get('/', (req, res) => {
  res.send('Hello World!');
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});