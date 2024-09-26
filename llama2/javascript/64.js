Here is the modified JavaScript code:


(async function() {
  const message = new TextEncoder().encode("Hello, World!");
  const keyPair = await window.crypto.subtle.generateKey(
    {
      name: "RSA-OAEP",
      modulusLength: 2048,
      publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
      hash: { name: "SHA-256" },
    },
    true,
    ["encrypt", "decrypt"]
  );

  const publicKey = keyPair.publicKey;
  const privateKey = keyPair.privateKey;

  const encrypted = await window.crypto.subtle.encrypt(
    {
      name: "RSA-OAEP",
    },
    publicKey,
    message
  );

  const envelope = await window.crypto.subtle.decrypt(
    {
      name: "RSA-OAEP",
    },
    privateKey,
    encrypted
  );

  console.log(new TextDecoder().decode(envelope));
})();