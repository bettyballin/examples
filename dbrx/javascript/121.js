// Import jsonwebtoken lib
const jwt = require('jsonwebtoken');

// Assuming publicKeyPEM contains your Public Key in PEM format and tokenString has JWT Token string
const publicKeyPEM = 'your-public-key-in-PEM-format';
const tokenString = 'your-JWT-token-string';

try {
  // Verify signature of received token using public key
  const decodedToken = jwt.verify(tokenString, publicKeyPEM);

  console.log(decodedToken); // Decoded payload if the Signature is valid.
} catch (error) {
  console.error(error);
}