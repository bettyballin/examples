import * as CryptoJS from 'crypto-js';

export function encryptByAES(message, key) {
  const encryptedMessage = CryptoJS.AES.encrypt(
    message,
    CryptoJS.enc.Utf8.parse(key),
    { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 }
  );

  return encryptedMessage;
}

function toBase64String(words) {
  return words.toString(CryptoJS.enc.Base64);
}

const key = 'xxxxxxxxxxxxxxxxxxxxxxxxx';
let encry = encryptByAES('test message', key);

console.log('Encrypted to string(): ', encry.toString());
// Prints U2FsdGVkX19WZDGZBnr+dB6qJA6bfUpp1kmhSK6E0t6TeuJU78BkyUkIthWnnWnX99Q9Eeq0pbdLWlgTx576MIV9FDYDcjcajlApXr/6r9k=

let b64words = toBase64String(encry.ciphertext);
console.log('Ciphertext: ', b64words); // Prints zqokDpt9SmnWSaFIroTS3pN64lTvwGTJSQi2Faedadf31D0R6rSlt0taWBPHnvowhX0UNgNyNxqOUClev/qv2Q==

// Decrypting b64words
const decrypted = CryptoJS.AES.decrypt(
  CryptoJS.enc.Base64.parse(b64words),
  CryptoJS.enc.Utf8.parse(key),
  { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 }
);

console.log('Decrypted: ', decrypted.toString(CryptoJS.enc.Utf8));