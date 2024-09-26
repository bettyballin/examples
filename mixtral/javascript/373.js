async function decrypt(key, iv, ciphertext) {
  const keyObject = await crypto.subtle.importKey('raw', hexToArrayBuffer(key), 'AES-CBC', false, ['decrypt']);

  return new Promise((resolve, reject) =>
    crypto.subtle
      .decrypt({ name: "AES-CBC", iv: hexToArrayBuffer(iv) }, keyObject, hexToArrayBuffer(ciphertext))
      .then(plainTextBuffer => {
        const decoder = new TextDecoder();

        resolve(decoder.decode(new Uint8Array(plainTextBuffer)));
      })
      .catch(error => reject(error))
  );
}

function hexToArrayBuffer(hexString){
   var result = new Uint8Array(hexString.length/2);

   for (var i=0;i<hexString.length/2 ;++i) {
      result[i] = parseInt(hexString.substr(i*2,2),16);
   }
   return result;
}