const forge = require('node-forge');

const dataToEncrypt = 'hi';

// Derive key from password
let md = forge.md.sha256.create();
md.update(Buffer.from('redacted12345678', 'utf8'));
const derivedKey = Buffer.alloc(32);
md.digest().copy(derivedKey, 0, 0, md.digest().byteLength);

// Encrypt data
const cipher = forge.cipher.createCipher('AES-CTR', derivedKey);
const iv = Buffer.from([17, 185, 49, 60, 23, 12, 16, 1]);

// Set IV
const startIV = forge.util.createBuffer(iv);
cipher.start({
  iv: startIV
});

const encryptedData = cipher.update(forge.util.createBuffer(dataToEncrypt));
encryptedData.output();

console.log(encryptedData.toHex());