const crypto = require('crypto').webcrypto;

const initializationVector = crypto.getRandomValues(new Uint8Array(12));

console.log(initializationVector);