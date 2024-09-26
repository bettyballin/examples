function b64ToAb(base64) {
  const binaryString = window.atob(base64);
  let len = binaryString.length;
  const bytes = new Uint8Array(len);

  for (let i = 0; i < len; ++i) {
    bytes[i] = binaryString.charCodeAt(i);
  }

  return bytes.buffer;
}

const base64PrivateKey = "your_base64_private_key_here"; // replace with your base64 private key
const abPrivateKey = b64ToAb(base64PrivateKey);

console.log(abPrivateKey);