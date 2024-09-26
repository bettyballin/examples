const express = require('express');
const sanitizer = require('sanitizer');

const app = express();

app.get('/nothing/:code', function(req, res) {
   var code = sanitizer.sanitize(req.params.code);
   res.send(code)
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});