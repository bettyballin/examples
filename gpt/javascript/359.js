
const CryptoJS = require('crypto-js');

// Generate nonce
const nonce = CryptoJS.lib.WordArray.random(32);
const encodedNonce = CryptoJS.enc.Base64.stringify(nonce);
pm.environment.set('nonce', encodedNonce);

// Generate created
const created = new Date().toISOString();
pm.environment.set('created', created);

// Generate password hash
const password = 'SECRETPASSWORD';
const sha1Password = CryptoJS.SHA1(password);
const binaryPassword = CryptoJS.enc.Base64.parse(sha1Password.toString(CryptoJS.enc.Base64));
const binaryNonceCreatedPassword = nonce.concat(CryptoJS.enc.Utf8.parse(created), binaryPassword);
const passwordHash = CryptoJS.SHA1(binaryNonceCreatedPassword).toString(CryptoJS.enc.Base64);
pm.environment.set('passwordHash',
