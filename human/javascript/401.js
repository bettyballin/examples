const http = require('http');

http.createServer((req, res) => {
  res.setHeader("Content-Security-Policy", "script-src 'self' www.google-analytics.com");
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.end('Hello World\n');
}).listen(3000, () => {
  console.log('Server running on port 3000');
});