This is not JavaScript code, it's Apache mod_rewrite configuration. You can't execute it as JavaScript. However, here is the equivalent JavaScript code using Node.js and Express.js:


const express = require('express');
const app = express();

app.use((req, res, next) => {
  const userAgent = req.header('User-Agent');
  if (userAgent && (userAgent.startsWith('BlackWidow') || userAgent.startsWith('Zeus'))) {
    res.status(403).send('Forbidden');
  } else {
    next();
  }
});

app.use((req, res) => {
  res.status(404).send('Not Found');
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});