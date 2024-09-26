Content-Security-Policy: default-src 'self'; img-src 'self' https://ads.example.com; script-src 'self' https://ads.example.com; frame-src 'self' https://ads.example.com



const helmet = require('helmet');

const express = require('express');
const app = express();

app.use(helmet.contentSecurityPolicy({
  directives: {
    defaultSrc: ["'self'"],
    imgSrc: ["'self'", 'https://ads.example.com'],
    scriptSrc: ["'self'", 'https://ads.example.com'],
    frameSrc: ["'self'", 'https://ads.example.com']
  }
}));

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});