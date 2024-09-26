const co = require('co');
const request = require('request');
const crypto = require('crypto');

const computeHash = co.wrap(function* main(url) {
  return new Promise((resolve, reject) => {
    const req = request({ url });
    const hash = crypto.createHash('sha1');

    // Pipe the response directly into the hash function
    req
      .on('error', (err) => {
        console.log(`Error: ${err}`);
        reject(err);
      })
      .pipe(hash)
      .setEncoding('binary')
      .once('finish', () => resolve(hash.read().toString('hex')));
  });
});

// Test the function
computeHash('http://example.com')
  .then(hash => console.log(`Hash: ${hash}`))
  .catch(err => console.log(`Error: ${err}`));