const JSEncrypt = require('jsencrypt');

var encrypt = new JSEncrypt();

// Set the private key
encrypt.setPrivateKey('-----BEGIN RSA PRIVATE KEY-----\
' +
    'your-privatekey\
' +
    '-----END RSA PRIVATE KEY-----');

var base64_encoded_ciphertext = "your-base64-encoded-ciphertext";
var decrypted = encrypt.decrypt(atob(base64_encoded_ciphertext));
console.log('Decrypted:', decrypted);