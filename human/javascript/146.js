var helmet = require('helmet');

// Sets "Content-Security-Policy: script-src 'self' https://maps.googleapis.com https://maps.gstatic.com; object-src 'self'"
var csp = helmet.contentSecurityPolicy({
  directives: {
    "script-src": ["'self'", "https://maps.googleapis.com", "https://maps.gstatic.com"],
    "object-src": ["'self'"]
  }
});

// Express.js usage
var express = require('express');
var app = express();
app.use(csp);