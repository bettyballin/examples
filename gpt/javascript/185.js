
// Encrypt
function encryptWithAES(text, password) {
    const encrypted = CryptoJS.AES.encrypt(text, password);
    return encrypted.toString();
}

// Decrypt
function decryptWithAES(ciphertext, password) {
    const decrypted = CryptoJS.AES.decrypt(ciphertext, password);
    return decrypted.toString(CryptoJS.enc.Utf8);
}

// Usage
const password = 'mysecretpassword'; // Replace with your password
const originalText = 'Hello, World!';

// Encrypt
const encryptedText = encryptWithAES(originalText, password);
console.log('Encrypted:', encryptedText);

// Decrypt
const decryptedText = decryptWithAES(encryptedText,
