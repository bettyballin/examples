
const crypto = require('crypto');

express.use(function(req, res, next) {
  // Step 1: Generate a unique nonce for each request
  const nonce = crypto.randomBytes(16).toString('base64');

  // Step 2: Include the nonce in the CSP header
  res.set({
    "Content-Security-Policy": `script-src 'self' 'nonce-${nonce}'`
  });

  // Make the nonce available to your views/templates if necessary
  res.locals.nonce = nonce;

  next();
});

