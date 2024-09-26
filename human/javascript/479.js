This is not JavaScript code, but rather an XML configuration snippet for ASP.NET. However, I can provide you with an equivalent JavaScript code that achieves the same functionality using Node.js and Express.js:


const express = require('express');
const app = express();

app.use((req, res, next) => {
  if (req.user && req.user.roles.includes('secure_role1')) {
    next();
  } else {
    res.status(401).send('Access Denied');
  }
});

// Your routes and application logic goes here