var ivHexString = "myIv"; // replace this string with your actual hexadecimal encoded IV
var keyBase64String = "myKey"; // replace this string with your base64-encoded encryption key

// Convert the IV and Key to WordArray
var ivWordArray = CryptoJS.enc.Hex.parse(ivHexString);
var keyWordArray = CryptoJS.enc.Base64.parse(keyBase64String);

// Create a new cipher params object
var encryptedDataCipherParams = {
  ciphertext: CryptoJS.lib.WordArray.create(), // assuming you need to create an empty WordArray
  iv: ivWordArray
};