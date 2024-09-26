
const helmet = require('helmet');

app.use(
  helmet.contentSecurityPolicy({
    directives: {
      "script-src": ["'self'"]
    }
  })
);

