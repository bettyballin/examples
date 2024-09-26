const fs = require('fs');
const https = require('https');

const secure = {
  "port": 8433,
  "certificate": "server.pem",
  "password": ""
};

const options = {
  key: fs.readFileSync(secure.certificate),
  cert: fs.readFileSync(secure.certificate),
  passphrase: secure.password
};

https.createServer(options, (req, res) => {
  res.writeHead(200);
  res.end('Secure Server Running on port ' + secure.port);
}).listen(secure.port);