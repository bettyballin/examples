const crypto = require('crypto').webcrypto;

(async () => {
  const keyLength = 256;
  const symKey = await crypto.subtle.generateKey({
    name: 'AES-GCM',
    length: keyLength,
  }, true, ['encrypt', 'decrypt']);

  const iv = crypto.getRandomValues(new Uint8Array(12));
  const param1 = 'Hello';
  const param2 = 'World';

  const encryptedData = await crypto.subtle.encrypt({
    name: 'AES-GCM',
    iv,
  }, symKey, new TextEncoder().encode(JSON.stringify([param1, param2])));

  console.log(encryptedData);
})();