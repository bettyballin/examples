const http = require('http');

const options = {
  hostname: 'example.com',
  port: 80,
  path: '/',
  method: 'GET',
  headers: {
    'Accept': '*/*'
  }
};

const req = http.request(options, (res) => {
  console.log(`HTTP/${res.httpVersion} ${res.statusCode} ${res.statusMessage}`);
  console.log(res.headers);
});

req.on('error', (error) => {
  console.error(error);
});

req.end();