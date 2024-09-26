const express = require('express');
const app = express();

app.get('/', (req, res) => {
  res.send('Hello from web server!');
});

app.listen(3000, () => {
  console.log('Web server listening on port 3000');
});

const axios = require('axios');

axios.get('http://localhost:3000')
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });