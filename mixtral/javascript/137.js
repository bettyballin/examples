const express = require('express');
const { JSDOM } = require('jsdom');
const createDOMPurify = require('dompurify');

const app = express();

app.get('/nothing/:code', function(req, res) {
  const window = new JSDOM('').window;

  // Create a sanitizer
  var DOMSanitize = createDOMPurify(window);

  let code = req.params.code

  // Sanitize the input
  let cleanCode = DOMSanitize.sanitize(code)

  res.send(cleanCode);
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});