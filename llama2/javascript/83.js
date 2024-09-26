const crypto = require('crypto');

const clientKey = 'test';
const secretKey = '2ITrhVxr1/4BOxNVNcECnaSh0cW36LiMZWVQ0DaFncY=';
const requestUrl = 'https://example.com/api/endpoint';

const timestamp = Math.floor(Date.now() / 1000);
const signature = crypto.createHmac('sha256', secretKey)
  .update(`${clientKey}${timestamp}`)
  .digest('base64');

const headers = {
  'X-Client-Key': clientKey,
  'X-Signature': signature,
  'X-Timestamp': timestamp.toString()
};

const options = {
  method: 'GET',
  url: requestUrl,
  headers: headers
};

const https = require('https');
const req = https.request(options, (res) => {
  console.log(`statusCode: ${res.statusCode}`);
  console.log(`headers: ${JSON.stringify(res.headers)}`);
  res.on('data', (d) => {
    process.stdout.write(d);
  });
});

req.on('error', (error) => {
  console.error(error);
});

req.end();