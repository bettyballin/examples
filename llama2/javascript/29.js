var sjcl = require('sjcl');

var secret = 'your_secret_key'; // keep this secure!
var assertion = 'your_assertion_data';
var salt = 'your_static_salt';
var iv = 'your_static_iv';

// Prepare the CMAC-AES context
var ctx = new sjcl.cipher.aes(secret, {
  mode: 'ccm',
  iv: sjcl.codec.utf8String.toBits(iv),
  salt: sjcl.codec.utf8String.toBits(salt)
});

// Encrypt and get the CMAC
var encryptedData = ctx.encrypt(sjcl.codec.utf8String.toBits(assertion));
var cmac = sjcl.codec.hex.fromBits(encryptedData.tag);

// Use the CMAC as your token
console.log('CMAC-AES Token: ' + cmac);