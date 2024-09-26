const express = require('express');
const app = express();

app.get('/nothing/:code', function(req, res) {
   var code = escape(req.params.code);
   res.send(code)
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});