const express = require('express');
const app = express();

app.use((req, res, next) => {
  res.set("X-XSS-Protection", "1; mode=block");
  next();
});