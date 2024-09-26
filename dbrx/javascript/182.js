const { subtle } = window.crypto;

async function generateJwk() {
  const key = await subtle.generateKey(
    { name: 'AES-CBC', length: 256 },
    true,
    ['encrypt', 'decrypt']
  );
  const jwk = await subtle.exportKey('jwk', key);
  return new Uint8Array(jwk.k);
}

// Call the function to test it
generateJwk().then(key => console.log(key));