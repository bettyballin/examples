// Node.js equivalent
const http = require('http');

http.createServer((req, res) => {
  res.setHeader("Access-Control-Allow-Origin", "your.domain.here");
  // rest of your code...
});