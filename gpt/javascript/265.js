
function generateSignature(nonce, secretKey) {
  var message = nonce.toString();
  var secret = CryptoJS.enc.Utf8.parse(secretKey);
  var hash = CryptoJS.HmacSHA256(message, secret);
  return hash.toString(CryptoJS.enc.Base64);
}

// Example usage:
var nonce = new Date().getTime();
var secretKey = '9IeVABv94EQBnT6Mn73742kBZOmzFpsM+c62LU9b/h4=';
var signature = generateSignature(nonce, secretKey);
console.log(signature); // Should output the signature

