(async () => {
  const subtle = window.crypto.subtle;
  const publicKey = await subtle.generateKey({
    name: "RSASSA-PKCS1-v1_5",
    modulusLength: 2048,
    publicExponent: new Uint8Array([0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F]),
    hash: { name: "SHA-256" },
  }, true, ["sign", "verify"]);

  const privateKey = await subtle.exportKey("jwk", publicKey.privateKey);
  console.log(privateKey);
})();