const express = require('express');
const helmet = require('helmet');

const app = express();

app.use(helmet({
  contentSecurityPolicy: {
    directives: {
      "default-src": ["'self'"],
      "script-src": ["'self'", "https://cdn.jsdelivr.net"],
      "style-src": ["'self'", "https://fonts.googleapis.com"],
      "font-src": ["'self'", "https://fonts.gstatic.com"],
      "img-src": ["'self'", "https://i.imgur.com"],
      "object-src": ["'none'"],
      "upgrade-insecure-requests": [],
    },
  },
}));

app.get('/', (req, res) => {
  res.send('Hello, world!');
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});