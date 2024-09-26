
const crypto = require('crypto');

function generateSalt(length = 16) {
    return crypto.randomBytes(length).toString('hex');
}

function hashPassword(password, salt) {
    return new Promise((resolve, reject) => {
        // The number 64 denotes the length of the hash; 10000 is the number of iterations
        crypto.pbkdf2(password, salt, 10000, 64, 'sha512', (err, derivedKey) => {
            if (err) reject(err);
            else resolve(derivedKey.toString('hex'));
        });
    });
}

// Usage
const salt = generateSalt();
hashPassword('myPassword', salt)
    .then(hash => {
        console.log('Salt:', salt);
        console.log('Hash:', hash);
        // Store the salt and hash in the user's record in your database
    })
    .catch(console.error);

