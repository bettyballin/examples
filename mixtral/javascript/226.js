function decodeMessage(message) {
  try {
    message = nacl.util.encodeUTF8(message);
  } catch (ex) {
    alert('Cannot decode decrypted message to string');
    return;
  }
  return message;
}

// example usage:
var nacl = require('eccjs');
var message = new Uint8Array([72, 101, 108, 108, 111]); // example message
var decodedMessage = decodeMessage(message);
console.log(decodedMessage);