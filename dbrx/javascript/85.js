const express = require('express');
const app = express();
const { JSDOM } = require('jsdom');
const window = new JSDOM('').window;
global.document = window.document;

const createDOMPurify = require('dompurify');
const DOMPurify = createDOMPurify(window);

app.post('/nothing/:code', function(req, res) {
  const code = req.params.code;
  // Sanitize the input
  const sanitizedCode = DOMPurify.sanitize(code);
  res.send(sanitizedCode);
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});