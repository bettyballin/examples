(async () => {
  const keyDetails = await window.crypto.subtle.generateKey(
    {
      name: "RSA-OAEP",
      modulusLength: 2048,
      publicExponent: new Uint8Array([1, 0, 1]),
      hash: "SHA-256"
    },
    true,
    ["encrypt", "decrypt"]
  );

  const encodedText = new TextEncoder().encode("Hello, World!");

  const encryptedText = await window.crypto.subtle.encrypt(
    {
      name: "RSA-OAEP"
    },
    keyDetails.publicKey,
    encodedText
  );

  console.log(new Uint8Array(encryptedText));

  const decryptedText = await window.crypto.subtle.decrypt(
    {
      name: "RSA-OAEP"
    },
    keyDetails.privateKey,
    encryptedText
  );

  console.log(new TextDecoder().decode(decryptedText));
})();