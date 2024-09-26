const express = require('express');

let app = express();

app.use((req, res, next) => {
  let allowedOrigins = ['http://www.abc.com', 'https://www.xyz.com'];

  if (allowedOrigins.includes(req.headers['origin'])){
    // Set the Access-Control-Allow-Origin header to allow requests from this origin
    res.setHeader('Access-Control-Allow-Origin', req.headers['origin']);

    next();

  } else {

    return res.status(403).send({
      error: 'Request blocked due to CORS policy.'
    });

  };
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});