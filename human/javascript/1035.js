Here is the executable JavaScript code:


(async () => {

  // Generate
  const keyDetails = await window.crypto.subtle.generateKey(
    {
      name: 'RSASSA-PKCS1-v1_5',
      modulusLength: 2048, 
      publicExponent: new Uint8Array([1, 0, 1]),
      hash: { name: 'SHA-256' }, 
    },
    true, 
    ['verify', 'sign'] 
  );
  console.log(keyDetails)

  // Export
  const publicKey = await window.crypto.subtle.exportKey('jwk', keyDetails.publicKey);
  const privateKey = await window.crypto.subtle.exportKey('jwk', keyDetails.privateKey);
  console.log(publicKey)
  console.log(privateKey)

  // Adapt parameters and import
  publicKey.key_ops = ['encrypt'];
  privateKey.key_ops = ['decrypt'];
  publicKey.alg = 'RSA-OAEP-256';
  privateKey.alg = 'RSA-OAEP-256';
  const publicKeyReloaded = await window.crypto.subtle.importKey("jwk", publicKey, {name: "RSA-OAEP", hash: {name: "SHA-256"}}, true, ["encrypt"]);    
  const privateKeyReloaded = await window.crypto.subtle.importKey("jwk", privateKey,{name: "RSA-OAEP", hash: {name: "SHA-256"}}, true, ["decrypt"]);    
  console.log(publicKeyReloaded)
  console.log(privateKeyReloaded)

  // Encrypt/Decrypt
  const enc = new TextEncoder();
  const encodedText = enc.encode("testing 1234");
  const encryptedText = await window.crypto.subtle.encrypt({name: "RSA-OAEP"}, publicKeyReloaded, encodedText)
  console.log(ab2b64(encryptedText));
  const dec = new TextDecoder();
  const decryptedText = await window.crypto.subtle.decrypt({name: "RSA-OAEP"}, privateKeyReloaded, encryptedText)
  console.log(dec.decode(decryptedText));

  // Helper
  function ab2b64(arrayBuffer) {
    return window.btoa(String.fromCharCode.apply(null, new Uint8Array(arrayBuffer)));
  }

})();