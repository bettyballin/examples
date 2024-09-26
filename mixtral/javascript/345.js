const express = require('express');
const helmet = require('helmet');

const app = express();
app.use(
  helmet({
    contentSecurityPolicy: {
      directives: {
        defaultSrc: ["'self'", 'cdn.example.com'],
        scriptSrc: [
          "'unsafe-inline'",
          "https://stackpath.bootstrapcdn.com",
          ...helmet.contentSecurityPolicy.getDefaultDirectives().scriptSrc
        ]
      }
    }
  })
);

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});