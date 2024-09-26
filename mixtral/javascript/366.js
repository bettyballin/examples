async function signData(data, privateKey) {
  const encoder = new TextEncoder();

  // Convert the data to an ArrayBuffer
  let encodedData = encoder.encode(JSON.stringify(data));

  // Sign the payload
  let signature = await window.crypto.subtle.sign(
    {
      name: "ECDSA",
      hash: { name: "SHA-256" },
    },
    privateKey,
    encodedData
  );

  return new Uint8Array(signature);
}