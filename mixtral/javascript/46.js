const crypto = require('crypto');
const socket = require('socket.io-client')();

// Generate a secret key
let SECRET_KEY = 'my-secret';

function encrypt(data) {
  let cipher = crypto.createCipher('aes192', SECRET_KEY);
  return cipher.update(JSON.stringify(data), 'utf8', 'hex') + cipher.final('hex');
}

// Send encrypted data to the server
socket.emit("news", {
  hello: "world",
  encryptedData: encrypt({
    latitude: 40,
    longitude: -73
  })
});