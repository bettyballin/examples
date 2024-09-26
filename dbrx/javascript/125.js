const express = require('express');
const path = require('path');
const helmet = require('helmet');
const fs = require('fs');

const _port = 3000;
var app = express();

app.use(express.static(path.join(__dirname, '../public')));

// Use Helmet for CSP headers and other security features
app.use(helmet());

// Set up a route to serve the index.html file
app.get('/', (req, res) => {
  // Send the HTML content with proper Content-Type header
  res.set("Content-Type", "text/html");
  fs.readFile(path.join(__dirname, '../public/index.html'), 'utf8', (err, data) => {
    if (err) throw err;
    res.send(data);
  });
});

app.listen(_port, () => console.log(`listening port ${_port}\n__dirname : ${__dirname}`));