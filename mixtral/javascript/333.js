const crypto = window.crypto || window.msCrypto;
const base64ToArrayBuffer = (base64) => {
  const binaryString = window.atob(base64);
  const len = binaryString.length;
  const bytes = new Uint8Array(len);
  for (let i = 0; i < len; i++) {
    bytes[i] = binaryString.charCodeAt(i);
  }
  return bytes.buffer;
};

(async () => {
  const pkcs8 = await crypto.subtle.importKey(
    'pkcs8',
    base64ToArrayBuffer('your-private-key'),
    { name: "RSA-OAEP", hash: "SHA-256" },
    false,
    ['decrypt']
  );
  console.log(pkcs8);
})();