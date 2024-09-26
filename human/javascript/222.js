// This is not a JavaScript code, it's a C# code. 
// However, I can provide you with an equivalent JavaScript code using Node.js and Express.js:

const express = require('express');
const app = express();

app.get('/', (req, res) => {
  res.json({ Foo: "bar" });
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});