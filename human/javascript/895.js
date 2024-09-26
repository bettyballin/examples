// Include the JSEncrypt library
var JSEncrypt = require("jsencrypt");

// Set up the HTML elements
var pubkey = document.getElementById('pubkey');
var input = document.getElementById('input');
var privkey = document.getElementById('privkey');

// Encrypt with the public key...
var encrypt = new JSEncrypt();
encrypt.setPublicKey(pubkey.value);
var encrypted = encrypt.encrypt(input.value);

// Decrypt with the private key...
var decrypt = new JSEncrypt();
decrypt.setPrivateKey(privkey.value);
var uncrypted = decrypt.decrypt(encrypted);

// Now a simple check to see if the round-trip worked.
if (uncrypted == input.value) {
  alert('It works!!!');
}
else {
  alert('Something went wrong....');
}

// HTML elements for testing
// <textarea id="pubkey"></textarea>
// <textarea id="input"></textarea>
// <textarea id="privkey"></textarea>