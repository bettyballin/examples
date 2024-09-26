const crypto = require('crypto');
const bcrypt = require('bcrypt');

var SECRET_KEY = "mysecretkey"; // Use a securely generated random key

var password = "mypassword";

// Generate a salted hash using bcrypt
bcrypt.hash(password, 10, function(err, hash) {
  // Extract the first 8 bytes of the hash as the encryption key
  var key = hash.slice(0, 16);

  // Generate a random IV for DES-CBC
  var iv = crypto.randomBytes(8);

  // Create a DES-CBC cipher
  var cipher = crypto.createCipheriv('des-cbc', key.slice(0, 8), iv);

  // Encrypt the password using DES-CBC
  var encryptedPassword = Buffer.concat([cipher.update(password), cipher.final()]);

  console.log("Hash: ", hash);
  console.log("Key: ", key);
  console.log("IV: ", iv);
  console.log("Encrypted Password: ", encryptedPassword.toString('hex'));
});