var encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase");
console.log(encrypted.toString()); // U2FsdGVkX18fj+KyJ/Zv4Q==

// To decrypt:
var bytes  = CryptoJS.AES.decrypt(encrypted.toString(), "Secret Passphrase");
var originalText = bytes.toString(CryptoJS.enc.Utf8);
console.log(originalText); // Message