
// Assuming CryptoJS is already loaded in your environment
var message = "test";
var secret = "secret";

// Generate the HMAC hash
var hash = CryptoJS.HmacSHA256(message, secret);

// Convert the hash to a hexadecimal string
var hashInHex = hash.toString(CryptoJS.enc.Hex);

// Now convert the hexadecimal string to its raw bytes representation
var hashInBytes = CryptoJS.enc.Hex.parse(hashInHex);

// If you want to log it as a string similar to Python's output
var hashInBytesStr = hashInBytes.toString(CryptoJS.enc.Latin1);
console.log(hashInBytesStr);

