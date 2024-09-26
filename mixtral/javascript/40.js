const forge = require('node-forge');

// assuming keyPair is already generated
var keyPair = forge.pki.rsa.generateKeyPair({bits: 2048, e: 0x10001});

var nVal = JSON.stringify(keyPair.publicKey.n);
var eVal = JSON.stringify(keyPair.publicKey.e);

// Reconstruct the public key
var reconstructedPublicKey = forge.pki.setRsaPublicKey(JSON.parse(nVal), JSON.parse(eVal));

// Now you can use it to encrypt messages
var encrypted = reconstructedPublicKey.encrypt("Arbitrary Message Here");

console.log(encrypted);