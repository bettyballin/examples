// Not possible to directly translate Java to JavaScript, 
// as JavaScript does not have a direct equivalent to Java's @Override or WebSecurity.
// However, assuming you want to ignore certain routes in a Node.js Express application:

const express = require('express');
const app = express();

app.use('/s/**', (req, res, next) => {
  // ignoring the route, do nothing
});

// Alternatively, using a middleware to ignore routes:

const ignoreRoutes = ['/s/**'];

app.use((req, res, next) => {
  if (ignoreRoutes.some(route => req.url.startsWith(route))) {
    return;
  }
  next();
});