var CryptoJS = require("crypto-js");

var message = 'Hello World!';

// Generate a random 256 bits key
var keySize = 256;
var ivSize = 128;

var salt = CryptoJS.lib.WordArray.random(128/8);

var key = CryptoJS.PBKDF2(
    'Secret Passphrase',
    salt,
    {
        keySize: keySize /32,
        iterations: 999
    }
);

// Encrypt
var encrypted = CryptoJS.AES.encrypt(
   message,
   key,
   { iv: CryptoJS.lib.WordArray.random(ivSize/8) }
).toString();

console.log('Encrypted: ' + encrypted);