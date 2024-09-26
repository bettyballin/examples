function generateAesKey() {
  return CryptoJS.lib.WordArray.random(16);
}

function encryptWithAes(aesKey, msg) {
  const cipher = CryptoJS.AES.encrypt(msg, aesKey).toString();
  return cipher;
}

function decryptWithAes(aesKey, ctxt) {
  try {
    var bytes = CryptoJS.AES.decrypt(ctxt, aesKey);
    if (bytes && !CryptoJS.enc.Hex.parse(bytes).toString())
      return "";

    const decryptedData = bytes.toString(CryptoJS.enc.Utf8);

    // Check for padding errors
    var lastByte = CryptoJS.lib.WordArray.create([decryptedData.charCodeAt(decryptedData.length - 1)]);

    if (lastByte && !CryptoJS.pad.Pkcs7.unpad(bytes, bytes.sigBytes))
      return "";

    // Return decoded data
    return decryptedData;

  } catch {
     console.error("Error while AES Decryption");
   }
}

// Test the functions
var aesKey = generateAesKey();
console.log("Generated AES Key:", aesKey);

var message = "Hello, World!";
console.log("Message:", message);

var encrypted = encryptWithAes(aesKey, message);
console.log("Encrypted:", encrypted);

var decrypted = decryptWithAes(aesKey, encrypted);
console.log("Decrypted:", decrypted);