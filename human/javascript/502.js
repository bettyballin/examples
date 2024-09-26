// This is a PHP code snippet, not JavaScript. However, I will provide you with a JavaScript equivalent using the Express.js framework:

const express = require('express');
const app = express();

app.use((req, res, next) => {
  res.header("Access-Control-Allow-Origin", "https://www.facebook.com");
  next();
});