const forge = require('node-forge');

// assuming private_key and envelope are defined
var privateKey = forge.pki.privateKeyFromPem(private_key);
var theKey = privateKey.decrypt(forge.util.decode64(envelope), 'RSAES-PKCS1-V1_5');

// to make it executable, you can wrap it in a function
function decryptEnvelope(private_key, envelope) {
  var privateKey = forge.pki.privateKeyFromPem(private_key);
  var theKey = privateKey.decrypt(forge.util.decode64(envelope), 'RSAES-PKCS1-V1_5');
  return theKey;
}

// example usage:
var private_key = 'your_private_key_here';
var envelope = 'your_envelope_here';
var decryptedKey = decryptEnvelope(private_key, envelope);
console.log(decryptedKey);