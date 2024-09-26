
const crypto = require('crypto');

const algorithm = 'aes-256-cbc'; // You can choose other algorithms as well.
const password = 'password'; // Use a secure password and consider storing it safely.
const key = crypto.scryptSync(password, 'salt', 32); // Generate a key from the password.
const iv = crypto.randomBytes(16); // Initialization vector for AES.

function encrypt(text) {
    const cipher = crypto.createCipheriv(algorithm, key, iv);
    let encrypted = cipher.update(text, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    return {
        iv: iv.toString('hex'),
        content: encrypted
    };
}

const encryptedData = encrypt('plain text data');
console.log(encryptedData);

