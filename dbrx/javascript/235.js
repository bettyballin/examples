async function deriveSecretKey(privateKey, publicKey) {
  // Step 1: ECDH derivation
  const sharedKey = await window.crypto.subtle.deriveBits(
    {
      name: "ECDH",
      public: publicKey,
      private: privateKey,
    },
    256
  );

  // Convert the ArrayBuffer to a Uint8Array for easier manipulation.
  let derivedSharedKey = new Uint8Array(sharedKey);

  // Step 2: HKDF derivation (using HMAC-SHA-256)
  const hkdfInfo = new TextEncoder().encode("HKDF info");
  const hmacKey = await window.crypto.subtle.importKey(
    "raw",
    sharedKey,
    {
      name: "HMAC",
      hash: "SHA-256",
    },
    false, // extractable
    ["sign"]
  );

  let hkdfOutput;
  for (let i = 0; i < 10000; ++i) {
    const hmacSignature = await window.crypto.subtle.sign(
      {
        name: "HMAC",
        hash: "SHA-256",
      },
      hmacKey,
      derivedSharedKey
    );
    // Concatenate the HMAC signature with HKDF info.
    hkdfOutput = new Uint8Array(hkdfInfo.length + hmacSignature.byteLength);
    hkdfOutput.set(derivedSharedKey, 0); // Copy previous output to maintain state for next iteration.
    hkdfOutput.set(new Uint8Array(hmacSignature), derivedSharedKey.length);

    if (i === 9999) {
      break;
    }

    const newHmacKey = await window.crypto.subtle.importKey(
      "raw",
      hmacSignature,
      {
        name: "HMAC",
        hash: "SHA-256",
      },
      false, // extractable
      ["sign"]
    );
    derivedSharedKey = hkdfOutput.slice(0, 32); // Use the first 32 bytes as output.
    hmacKey = newHmacKey;
  }

  return window.crypto.subtle.importKey(
    "raw",
    hkdfOutput,
    {
      name: "AES-GCM",
    },
    true, // extractable
    ["encrypt", "decrypt"]
  );
}