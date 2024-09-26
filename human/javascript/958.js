const express = require('express');
const app = express();

app.get('/users/:userEmail', (req, res) => {
  const userEmail = req.params.userEmail;
  res.send(`User email: ${userEmail}`);
});

app.get('/products/:userId', (req, res) => {
  const userId = req.params.userId;
  res.send(`User ID: ${userId}`);
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});