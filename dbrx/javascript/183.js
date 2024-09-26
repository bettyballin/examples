async function encrypt(jwk, iv, plaintext) {
  const key = await crypto.subtle.importKey(
    'raw',
    jwk,
    { name: 'AES-CBC' },
    false,
    ['encrypt']
  );
  return new Uint8Array(await crypto.subtle.encrypt(
    { name: 'AES-CBC', iv: iv },
    key,
    plaintext
  ));
}