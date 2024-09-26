const crypto = require('crypto');

const algorithm = 'aes-256-cbc';
const password = 'my_secret_password';
const encrypted = 'your_encrypted_data_here';

const decipher = crypto.createDecipher(algorithm, password);

let decrypted = decipher.update(encrypted, 'hex', 'utf8');
decrypted += decipher.final('utf8');

console.log("Decrypted:", decrypted);