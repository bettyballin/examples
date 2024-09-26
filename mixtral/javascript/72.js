function decrypt(cipherTextCryptoJSObject, keyBase64String){
    var key = CryptoJS.enc.Base64.parse(keyBase64String);

    // Decrypt the data
    var plaintextWordArray = CryptoJS.AES.decrypt({
        ciphertext: cipherTextCryptoJSObject
      }, key, {
          iv: CryptoJS.enc.Hex.parse("00000000000000000000000000000000")
      });

    return plaintextWordArray.toString(CryptoJS.enc.Utf8);
}