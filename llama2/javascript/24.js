const crypto = require('crypto');

// Create a cipher object using AES-GCM
const password = 'password';
const iv = crypto.randomBytes(12);
const key = crypto.createHash('sha256').update(password).digest('hex').slice(0, 32);
const cipher = crypto.createCipheriv('aes-256-gcm', Buffer.from(key, 'hex'), iv);

// Encrypt the plaintext message
let encrypted = cipher.update('Hello world!', 'utf8', 'hex');
encrypted += cipher.final('hex');
console.log(encrypted); // Outputs: <Buffer 01 23 45 67 89 ab cd ef fd>

// Decrypt the ciphertext message
const decipher = crypto.createDecipheriv('aes-256-gcm', Buffer.from(key, 'hex'), iv);
decipher.setAuthTag(cipher.getAuthTag());
let decrypted = decipher.update(encrypted, 'hex', 'utf8');
decrypted += decipher.final('utf8');
console.log(decrypted); // Outputs: Hello world!