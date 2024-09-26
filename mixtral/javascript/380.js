(async () => {
  const importedPublicKey = await window.crypto.subtle.importKey(
    "spki",
    arrayBuffer,
    {
      name: "ECDSA",
      namedCurve: "P-256",
    },
    true,
    ["verify"]
  );

  // Then verify the signature
  let isValidSignature = false;
  try {
    const result = await window.crypto.subtle.verify(
      {
        name: "ECDSA",
        hash: { name: "SHA-256" },
      },
      importedPublicKey,
      base64ToArrayBuffer(encoded_sig),
      data
    );

    if (result) {
      isValidSignature = true;
    }
  } catch (e) {}

  function base64ToArrayBuffer(base64) {
    var binaryString = window.atob(base64);
    var len = binaryString.length;
    var bytes = new Uint8Array(len);
    for (var i = 0; i < len; i++) {
      bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes;
  }
})();