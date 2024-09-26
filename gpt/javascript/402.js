
function decryptString(key, ciphertext) {
  var iv = CryptoJS.enc.Utf8.parse(''); // Empty IV for compatibility with your C# code
  var encrypted = CryptoJS.enc.Base64.parse(ciphertext);
  var keyHash = CryptoJS.enc.Utf8.parse(key); // Parse the key (same as Encoding.UTF8.GetBytes in C#)

  // The actual decryption
  var decrypted = CryptoJS.AES.decrypt(
    { ciphertext: encrypted },
    keyHash,
    {
      iv: iv,
      padding: CryptoJS.pad.Pkcs7,
      mode: CryptoJS.mode.C
