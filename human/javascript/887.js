const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));

app.post('/', (req, res) => {
  const username = req.body.username.trim().replace(/[^a-zA-Z0-9\s]/g, '');
  console.log(username);
  res.end();
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});