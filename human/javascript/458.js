const express = require('express');
const app = express();

app.use((req, res, next) => {
  res.setHeader("Content-Security-Policy", "default-src 'self' data: 'unsafe-inline' 'unsafe-eval' https:");
  next();
});

app.get('/', (req, res) => {
  res.send('<script>alert("Hello, World!");</script>');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});