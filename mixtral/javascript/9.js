const CryptoJS = require("crypto-js");

// encrypt function
function encrypt() {
  // assuming 'iv' and 'encrypted' are defined elsewhere
  let iv = CryptoJS.lib.WordArray.random(16/4);
  let encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase", { iv: iv });

  let message = iv.concat(encrypted.ciphertext);
  let messageHexStr = CryptoJS.enc.Hex.stringify(message);
  return messageHexStr;
}

// decrypt function
function decrypt(data) {
  let ivAndCtWordArray = CryptoJS.enc.Hex.parse(data);
  let iv = CryptoJS.lib.WordArray.create(ivAndCtWordArray.words.slice(0, 4));
  let encryptedText = CryptoJS.lib.WordArray.create(ivAndCtWordArray.words.slice(4));

  let decrypted = CryptoJS.AES.decrypt(encryptedText, "Secret Passphrase", { iv: iv });
  return decrypted.toString(CryptoJS.enc.Utf8);
}

// usage
let encryptedMessage = encrypt();
console.log(encryptedMessage);

let decryptedMessage = decrypt(encryptedMessage);
console.log(decryptedMessage);