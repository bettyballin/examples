const express = require('express');
const app = express();

app.get('/', (req, res) => {
  res.cookie('tagname', 'test', {
    maxAge: 900000,
    httpOnly: true,
    secure: true
  });
  res.send('Cookie set!');
});

app.listen(3000, () => console.log('Server listening on port 3000'));