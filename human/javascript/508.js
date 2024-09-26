const express = require('express');
const app = express();

app.use((req, res, next) => {
  res.setHeader("Content-Security-Policy", "frame-src 'self' https://salesforce.com;");
  next();
});

app.get('/', (req, res) => {
  res.send('Hello World!');
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});