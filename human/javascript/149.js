This is not JavaScript code, it appears to be Apache HTTP Server configuration directives. However, I can provide you with equivalent JavaScript code that achieves a similar functionality, assuming you want to block a specific IP address:


const express = require('express');
const app = express();

const blockedIp = '123.45.67.89';

app.use((req, res, next) => {
  if (req.ip === blockedIp) {
    res.status(403).send('Forbidden');
  } else {
    next();
  }
});

app.get('*', (req, res) => {
  res.send('Hello World!');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});