const express = require('express');
const helmet = require('helmet');
const app = express();

app.use(
  helmet.contentSecurityPolicy({
    directives: {
      defaultSrc: ["'self'", 'https://cdn.jsdelivr.net'],
      scriptSrc: ["'self'", 'https://code.jquery.com', "'unsafe-inline'"],
      styleSrc: ["'self'", 'https://stackpath.bootstrapcdn.com', "'unsafe-inline'"]
    }
  })
);