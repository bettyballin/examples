const helmet = require('helmet');

helmet.contentSecurityPolicy({
  directives: {
    defaultSrc: ["'self'"],
    frameAncestors: ["'self'"],
    formAction: ["'self'"],
    scriptSrc: ["'strict-dynamic'", "'nonce-4VOtk0Uo1l7pwtC'"]
  }
});