
(async () => {
  try {
    // Define the algorithm details for the ECDSA keys to generate
    const keyPair = await window.crypto.subtle.generateKey(
      {
        name: "ECDSA",
        namedCurve: "P-256" // Can be "P-256", "P-384", or "P-521" (corresponds to secp256r1, secp384r1, secp521r1 respectively)
      },
      true, // whether the key is extractable (i.e. can be used in exportKey)
      ["sign", "verify"] // can be any combination of "sign" and "verify"
    );
    
    // Export the public key to a usable format like JWK, ArrayBuffer, etc.
    const publicKey = await window.crypto.subtle.exportKey(
     
