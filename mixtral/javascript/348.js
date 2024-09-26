const forge = require('node-forge');
const pki = forge.pki;

// Load private key
var privKeyPem = '-----BEGIN PRIVATE KEY-----\
MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDl56jzjz4z9G+\
hUjZQDp/2QyG9uZQ8RwvLnS8SUTWk7sQXt2VmK1kSNtjzNgYZ2c0C4uJL+\
jzF4zD0zLZcZpY4z+2kY1zZjzNkY1zZjz+\
-----END PRIVATE KEY-----';

var privKey = pki.privateKeyFromPem(privKeyPem);

// Sign message
var msgHash = forge.md.sha256.create();
msgHash.update('message to sign');

var signature = privKey.sign(msgHash);

console.log(signature);