// Split data
var decodedDataFromBase64String = "your_base64_encoded_string";
var parts = decodedDataFromBase64String.split('.');

// Decrypt
var bytes  = CryptoJS.AES.decrypt(parts[0], "password");

// Generate new HMAC
var hmacNew = CryptoJS.HmacSHA256(bytes.toString(), "secret key for authentication").toString();

if (hmacNew === parts[1]) {
  console.log('Authentication successful');
} else {
  throw 'Authentication failed';
}