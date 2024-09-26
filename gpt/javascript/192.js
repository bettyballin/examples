
const crypto = require('crypto');
const http = require('http'); // or 'https' for SSL/TLS
const { promisify } = require('util');
const stream = require('stream');
const pipeline = promisify(stream.pipeline);

async function computeHash(url) {
  return new Promise((resolve, reject) => {
    const hash = crypto.createHash('sha1');
    hash.setEncoding('hex');

    http.get(url, response => {
      if (response.statusCode !== 200) {
        reject(new Error(`Request Failed. Status Code: ${response.statusCode}`));
        return;
      }
      response.on('error', reject);
      response.pipe(hash)
        .on('finish', function () {
          hash.end();
          resolve(hash.read());
        });
    }).on('error', reject);
  });
}

// Usage
(async () => {
  try {
    const hash = await computeHash('http://arxiv.org/pdf/1001.1234v3
