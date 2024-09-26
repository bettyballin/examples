This is not JavaScript code, it's an Apache mod_rewrite configuration. However, I can provide you with a JavaScript equivalent using Node.js and Express.js:


const express = require('express');
const app = express();

app.get('/hellothere/captcha.php', (req, res, next) => {
  const referer = req.header('Referer');
  if (referer && !referer.startsWith('http://yourdomain.com') && !referer.startsWith('https://yourdomain.com') && !referer.startsWith('http://www.yourdomain.com') && !referer.startsWith('https://www.yourdomain.com')) {
    res.status(403).send('Forbidden');
  } else {
    next();
  }
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});