const express = require('express');
const app = express();

app.use((req, res, next) => {
  res.setHeader("Content-Security-Policy", "script-src 'self' 'nonce-random1'");
  next();
});

app.get('/', (req, res) => {
  res.send(`
    <html>
      <head>
        <script nonce="random1">console.log('Script executed!');</script>
      </head>
      <body>
        <h1>Hello World!</h1>
      </body>
    </html>
  `);
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});