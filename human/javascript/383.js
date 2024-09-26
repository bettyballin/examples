const crypto = require('crypto');
const request = require('request');

var url = 'https://example.com'; // Replace with the URL you want to hash
var hasher = crypto.createHash('sha1');
hasher.setEncoding('hex');
request(url).pipe(hasher).on('finish', function() {
  console.log('Hash is', hasher.read());
});