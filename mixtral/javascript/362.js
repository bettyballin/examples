const express = require('express');
const helmet = require('helmet');

const app = express();

app.use(
  helmet({
    contentSecurityPolicy: {
      directives: {
        connectSrc: ["'self'", 'ws://localhost:*']
      }
    }
  })
);

// Rest of your server setup

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});