async function verifySignature(data, signature, publicKey) {
  const encoder = new TextEncoder();

  // Convert the data to an ArrayBuffer
  let encodedData = encoder.encode(JSON.stringify(data));

  try {
    await window.crypto.subtle.verify(
      {
        name: "ECDSA",
        hash: { name: "SHA-256" },
      },
      publicKey,
      signature,
      encodedData
    );

    return true;
  } catch (error) {
    console.log(error);

    // Signature verification failed
    return false;
  }
}