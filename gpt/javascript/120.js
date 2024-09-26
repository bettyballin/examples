
var forge = require('node-forge');
var rsa = forge.pki.rsa;

// Generate key pair
var keypair = rsa.generateKeyPair({bits: 2048, e: 0x10001});

// Serialize public key
var publicKeyPem = forge.pki.publicKeyToPem(keypair.publicKey);

// Serialize private key
var privateKeyPem = forge.pki.privateKeyToPem(keypair.privateKey);

// ... store PEMs somewhere safe ...

// Deserialize public key
var
