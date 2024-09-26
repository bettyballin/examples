
const crypto = require('crypto');
const CryptoJS = require('crypto-js');

const payload = {
    name: 'John Doe'
};

// Generate a 32-byte key and 16-byte IV from the password
const password = 'devOps';
const key = crypto.scryptSync(password, 'salt', 32);
const iv = crypto.randomBytes(16); //
