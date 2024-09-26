const helmet = require('helmet');

helmet.contentSecurityPolicy({
  directives: {
    defaultSrc: ["'self'"],
    scriptSrc: ["'self'", 'cdnjs.cloudflare.com'],
    styleSrc: ["'self'", "'unsafe-inline'"]
  }
});