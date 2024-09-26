const KJUR = require('jsrsasign');

const rsa = new KJUR.crypto.RSA();
rsa.generate(4096);

// Export public key as SubjectPublicKeyInfo
let pubPEM = `-----BEGIN PUBLIC KEY-----\n`;
pubPEM += `${KJUR.crypto.Util.bytesToBase64(rsa.getPubKey())}\n`
pubPEM += `-----END PUBLIC KEY-----`;

console.log(pubPEM);