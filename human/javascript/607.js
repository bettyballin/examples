const helmet = require('helmet');

helmet.contentSecurityPolicy({
  directives: {
    scriptSrc: [
      (req, res) => `'nonce-${res.locals.nonce}'`,
      "'strict-dynamic'",
      "'unsafe-inline'",
      "https:"
    ]
  }
});