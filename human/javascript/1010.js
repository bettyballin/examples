const crypto = require("crypto");
const Algorithm = "aes-256-cbc";

function encrypt(plainText, key, iv, outputEncoding = "base64") {
    const cipher = crypto.createCipheriv(Algorithm, key, iv);
    const output = Buffer.concat([cipher.update(plainText), cipher.final()]).toString(outputEncoding);
    return output.replace(/\+/g, '-').replace(/\//g, '_').replace(/=/g, '');
}

function decrypt(cipherText, key, iv, outputEncoding = "utf8") {
    cipherText = Buffer.from(cipherText, "base64");
    const cipher = crypto.createDecipheriv(Algorithm, key, iv);
    return Buffer.concat([cipher.update(cipherText), cipher.final()]).toString(outputEncoding);
}

const KEY = 'KFmnMAPzP!g@6Dy5HD?JSgYC9obE&m@m';
const IV = KEY.slice(0,16);

// Taking the output from our C# sample...
const encrypted = 'SORoNS48u0KniiANU3Y9Mw==';
console.log("Encrypted (base64):", encrypted);
const decrypted = decrypt(encrypted, KEY, IV)
console.log("Decrypted:", decrypted);