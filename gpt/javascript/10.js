
   async function encryptData(publicKeyPem, data) {
       // Import the public key into the crypto API
       const publicKey = await window.crypto.subtle.importKey(
           'spki',
           pemToBuffer(publicKeyPem),
           {
               name: "RSA-OAEP",
               hash: {name: "SHA-256"}
           },
           true,
           ['encrypt']
       );

       // Encrypt the data
       const encrypted = await window.crypto
