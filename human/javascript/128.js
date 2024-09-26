const http = require('http');
const ipfilter = require('express-ipfilter');

const allowedIps = ['192.168.1.100', '192.168.1.200'];

const webServer = http.createServer((req, res) => {
  const clientIp = req.connection.remoteAddress;
  if (allowedIps.includes(clientIp)) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello, allowed client!');
  } else {
    res.writeHead(403, { 'Content-Type': 'text/plain' });
    res.end('Forbidden, your IP is not allowed!');
  }
});

webServer.listen(80, () => {
  console.log('Web server listening on port 80');
});