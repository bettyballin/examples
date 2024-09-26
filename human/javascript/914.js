const express = require('express');
const helmet = require('helmet');

const app = express();

// This disables the `contentSecurityPolicy` middleware but keeps the rest.
app.use(
  helmet({
    contentSecurityPolicy: false,
  })
);

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});