const forge = require('node-forge');

const data = 'hi', iv = '1111111111111111', password = 'redacted12345678';

const key = forge.md.sha256.create().update(password).digest().getBytes();

const cipher = forge.cipher.createCipher('AES-CTR', key);
cipher.start({ iv: iv.getBytes() });
cipher.update(forge.util.createBuffer(data));
cipher.finish(); 
const encryptedBytes = cipher.output.getBytes();
const encryptedBase64 = forge.util.encode64(encryptedBytes);

console.log("encrypted: " + encryptedBase64);

const decipher = forge.cipher.createDecipher('AES-CTR', key)
decipher.start({ iv: iv.getBytes() });
decipher.update(forge.util.createBuffer(encryptedBytes));
decipher.finish(); 
const decryptedBytes = decipher.output.getBytes();
const decryptedString = forge.util.decodeUtf8(decryptedBytes);

console.log("decrypted: " + decryptedString);

const recipher = forge.cipher.createCipher('AES-CTR', key);
recipher.start({ iv: iv.getBytes() });
recipher.update(forge.util.createBuffer(decryptedBytes));
recipher.finish(); 
const reencryptedBytes = recipher.output.getBytes();
const reencryptedBase64 = forge.util.encode64(reencryptedBytes);

console.log("reencrypted: " + reencryptedBase64);