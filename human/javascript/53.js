const http = require('http');

http.createServer((req, res) => {
  res.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
  res.setHeader("Pragma", "no-cache"); //HTTP 1.0
  res.setDateHeader("Expires", 0); //prevent caching at the proxy server
  res.end();
}).listen(3000);