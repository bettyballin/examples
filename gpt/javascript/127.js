
// Assuming you have a crypto key for signing
async function signData(privateKey, data) {
  const encoder = new TextEncoder();
  const encodedData = encoder.encode(data);

  const signature = await window.crypto.subtle.sign(
    {
      name: "RSASSA-PKCS1-v1_5",
    },
    privateKey,
    encodedData
  );

  return signature;
}

// You must obtain `privateKey` through the Web Crypto API,
// typically either by generating it or by importing it.

