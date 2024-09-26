
// Step 1: Encrypt plaintext with AES
var plaintext = "some plaintext";
var password = "password";
var encrypted = CryptoJS.AES.encrypt(plaintext, password);

// Step 2: Generate HMAC for the ciphertext
var hmac = CryptoJS.HmacSHA256(encrypted.toString(), password);

// Step 3: Concatenate HMAC with ciphertext
var hmacAndCiphertext = hmac.toString() + encrypted.toString();

// When you need to decrypt:
// Step 4a: Separate the HMAC from the ciphertext
var receivedHmac = hmacAndCiphertext.substring(0, 64);
var receivedCiphertext = hmacAndCiphertext.substring(64);

// Step 4b: Generate HMAC for the received ciphertext and verify
