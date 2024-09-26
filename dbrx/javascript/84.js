const express = require('express');
const helmet = require('helmet');

const app = express();

app.use(helmet());

// Your routes here
app.get('/', (req, res) => {
  res.send('Hello, World!');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});