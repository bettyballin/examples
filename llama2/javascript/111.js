(async () => {
  async function pbkdf2_derive_salted_key(key, data, salt, iterations) {
    const hmac = await crypto.subtle.importKey(
      'raw',
      new Uint8Array(key),
      { name: 'HMAC', hash: 'SHA-1' },
      true,
      ['sign', 'verify']
    );

    const derivedKey = await crypto.subtle.deriveKey(
      {
        name: 'PBKDF2',
        salt: new Uint8Array(salt),
        iterations: iterations,
        hash: 'SHA-1',
      },
      hmac,
      'raw',
      256
    );

    return derivedKey;
  }

  // example usage
  const key = new TextEncoder('utf-8').encode('my key');
  const salt = new TextEncoder('utf-8').encode('my salt');
  const iterations = 1000;

  const derivedKey = await pbkdf2_derive_salted_key(key, {}, salt, iterations);
  console.log(derivedKey);
})();