This is not JavaScript code, it's an Apache server configuration. However, I can provide you with the equivalent JavaScript code that achieves the same functionality, using the Express.js framework:


const express = require('express');
const app = express();

app.use((req, res, next) => {
  const referer = req.headers['referer'];
  if (referer && !(referer.startsWith('http://mydomain.com') || referer.startsWith('http://www.mydomain.com'))) {
    if (req.url.endsWith('.gif') || req.url.endsWith('.jpg') || req.url.endsWith('.js') || req.url.endsWith('.css')) {
      res.status(403).send('Forbidden');
    } else {
      next();
    }
  } else {
    next();
  }
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});