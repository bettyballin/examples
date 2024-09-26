const forge = require('node-forge');
forge.options.usePureJavaScript = true;

// Generate a key pair
let keys = forge.pki.rsa.generateKeyPair(1024);

console.log(forge.pki.privateKeyToPem(keys.privateKey));