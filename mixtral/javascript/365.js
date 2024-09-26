async function generateKeys() {
  const keyPair = await window.crypto.subtle.generateKey(
    {
      name: "ECDSA",
      namedCurve: "P-256"
    },
    true,
    ["sign", "verify"]
  );

  return keyPair;
}

generateKeys().then(keyPair => console.log(keyPair));