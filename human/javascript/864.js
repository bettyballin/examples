const crypto = require('crypto');

function decryptWithAes256(ciphertextToBeDecrypted, encryptorSecret) {
    const iv = ciphertextToBeDecrypted.substring(0, 16);
    const encrypted = ciphertextToBeDecrypted.substring(16);
    const decipher = crypto.createDecipheriv('aes-256-cbc', encryptorSecret.substring(0, 32), iv);
    let decrypted = decipher.update(encrypted, 'hex', 'utf8');
    decrypted += decipher.final('utf8');
    return decrypted;
}

// Test the function
const ciphertextToBeDecrypted = "f635ea7eb421b44f628d044112ca031c4b62a51693c7121b9f130d0cb78e25b5";
const encryptorSecret = "your_secret_key_here";
console.log(decryptWithAes256(ciphertextToBeDecrypted, encryptorSecret));