const express = require('express');
const app = express();
const session = require('express-session');
const uniqid = require('uniqid');
const crypto = require('crypto');
const fs = require('fs');

app.use(session({
  secret: 'secret',
  resave: false,
  saveUninitialized: true
}));

app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => {
  const token = crypto.createHash('md5').update(uniqid()).digest('hex');
  req.session.token = token;
  res.send(`
    <form method="POST">
      <input type="hidden" name="token" value="${token}" />
      <input type="text" name="message"><br />
      <input type="submit">
    </form>
  `);
});

app.post('/', (req, res) => {
  if (req.body.message && req.session.token && req.body.token === req.session.token) {
    const message = req.body.message;
    fs.appendFile('./messages.txt', `${message}<br />`, (err) => {
      if (err) throw err;
    });
  }
  res.redirect('/');
});

app.get('/messages', (req, res) => {
  fs.readFile('./messages.txt', 'utf8', (err, data) => {
    if (err) throw err;
    res.send(data);
  });
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});