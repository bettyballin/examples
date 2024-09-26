const fs = require('fs');
const ec = require('eccrypto');

const skeyPath = './path/to/your/skey'; // replace with your skey file path

const rawSkey = fs.readFileSync(skeyPath).toString('hex');

// Now you can use `rawSkey` as a hex string directly

// If you need to convert it back into an EC key do this

const privateKeyBuffer = Buffer.from(rawSkey, 'hex');

const sec = ec.recoverPrivateKey(privateKeyBuffer);