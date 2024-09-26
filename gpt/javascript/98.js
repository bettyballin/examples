
// Encrypting a message
var plaintext = "The quick brown fox jumps over the lazy dog";
var password = "password123";
var encrypted = sjcl.encrypt(password, plaintext);

console.log("Encrypted:", encrypted);

// Decrypting a message
try {
  var decrypted = sjcl.decrypt(password, encrypted);
  console.log("Decrypted:", decrypted);
} catch (e) {
  console.error("Decryption failed:", e);
}

