
const originalEncrypt = crypto.subtle.encrypt;

// In a security-checking function that runs periodically
if (crypto.subtle.encrypt !== originalEncrypt) {
    console.error('Security alert: encrypt function has been tampered with!');
}

