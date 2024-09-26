
var decrypted = CryptoJS.AES.decrypt(cipher, key, {
  iv: iv,
  mode: CryptoJS.mode.CFB,
  padding: CryptoJS.pad.NoPadding // Disable padding
});

