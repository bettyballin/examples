const encoder = new TextEncoder();
const encodedText = encoder.encode("testing 1234");

async function encryptText() {
  const encryptedText = await window.crypto.subtle.encrypt({
    name: "RSA-OAEP"
  }, 
  await window.crypto.subtle.generateKey({
    name: "RSA-OAEP",
    modulusLength: 2048,
    publicExponent: new Uint8Array([1, 0, 1]),
    hash: "SHA-256"
  }, 
  true, 
  ["encrypt"]), 
  encodedText);

  console.log(encryptedText);
}

encryptText();