const express = require('express');
const crypto = require('crypto');
const app = express();

// Generate a nonce value
function getNonce() {
  return crypto.randomBytes(16).toString('hex');
}

app.use(function(req, res, next) {
  const nonce = getNonce();
  
  // Set the Content-Security-Policy header with 'nonce-{random}'
  res.set({
    "Content-Security-Policy": `script-src 'self' 'nonce-${nonce}'`
  });

  // Add a script tag to your HTML response
  res.send(`
    <html>
      <body>
        <!-- Set the nonce value in your inline script -->
        <script nonce="${nonce}">
          console.log('Hello world!');
        </script>
      </body>
    </html>
  `);

  return next();
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});