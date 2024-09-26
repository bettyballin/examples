// Node.js service file

const http = require('http');
const url = require('url');

http.createServer((req, res) => {
  // Get all data coming in via GET or POST
  const vars = { ...url.parse(req.url, true).query, ...req.body };

  // Do something with the data coming in

  res.writeHead(200, { 'Content-Type': 'application/json' });
  res.end(JSON.stringify(vars));
}).listen(3000);