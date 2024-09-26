// This is not JavaScript code, it's a Content Security Policy (CSP) directive.
// However, here's how you might set it in a JavaScript environment:

const helmet = require('helmet');

helmet.contentSecurityPolicy({
  directives: {
    "style-src": ["'unsafe-inline'", "'self'"],
    "default-src": ["'self'"]
  }
});