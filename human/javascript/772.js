const https = require('https');
const fs = require('fs');

var req = https.request({ 
      host: '192.168.1.1', 
      port: 443,
      path: '/',
      ca: [fs.readFileSync('/path/to/certificate', {encoding: 'utf-8'})],
      method: 'GET',
      rejectUnauthorized: true,
      requestCert: true,
      agent: false
    }, (res) => {
  console.log('statusCode:', res.statusCode);
  console.log('headers:', res.headers);

  res.on('data', (d) => {
    process.stdout.write(d);
  });
});

req.on('error', (error) => {
  console.error(error);
});

req.end();