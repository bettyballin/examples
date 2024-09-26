const forge = require('node-forge');

// Generate a key pair for demonstration
var keypair = forge.pki.rsa.generateKeyPair(2048);
var publicKey = keypair.publicKey;
var privateKey = keypair.privateKey;

// convert a Forge public key to PEM-format
var pem = forge.pki.publicKeyToPem(publicKey);
console.log(pem);

// convert a PEM-formatted public key to a Forge public key
var publicKeyFromPem = forge.pki.publicKeyFromPem(pem);
console.log(publicKeyFromPem);

// convert a Forge private key to PEM-format
// (preferred method if you don't want encryption)
var privatePem = forge.pki.privateKeyToPem(privateKey);
console.log(privatePem);

// wraps and encrypts a Forge private key and outputs it in PEM format
// (preferred method if you do want encryption)
var encryptedPem = forge.pki.encryptRsaPrivateKey(privateKey, 'password');
console.log(encryptedPem);

// encrypts a Forge private key and outputs it in PEM format using OpenSSL's
// proprietary legacy format + encapsulated PEM headers (DEK-Info)
// (perhaps more compatible with some legacy OpenSSL-based applications)
var legacyEncryptedPem = forge.pki.encryptRsaPrivateKey(privateKey, 'password', {legacy: true});
console.log(legacyEncryptedPem);

// decrypts a PEM-formatted, encrypted private key
var decryptedPrivateKey = forge.pki.decryptRsaPrivateKey(encryptedPem, 'password');
console.log(decryptedPrivateKey);