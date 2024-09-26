// Create a new express app
const express = require('express');
const app = express();

// Require the express-mongo-sanitize middleware
const mongoSanitize = require('express-mongo-sanitize');

// Use the middleware to sanitize MongoDB queries
app.use(mongoSanitize());

// Start the express app
const port = 3000;
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});