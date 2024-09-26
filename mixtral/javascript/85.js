const crypto = require('crypto');

const message = "Hello, World!";
const hash = crypto.createHash('sha256');
hash.update(message);

const digest = hash.digest();
const arrayBuffer = new Uint8Array(digest).buffer;
console.log("Digest:", arrayBuffer);