// Node.js environment
const express = require('express');
const app = express();

app.get('/', (req, res) => {
  let username = req.user ? req.user.username : 'Guest';
  console.log(username);
  res.send(`Hello, ${username}!`);
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});