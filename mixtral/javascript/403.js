const b64ToBin = (b64) => {
  return atob(b64).split('').map((c) => c.charCodeAt(0));
};

const importB64Key = async (base64key) => {
  const bin = b64ToBin(base64key);

  // Import the key as a spki formatted public ECDH key
  return await window.crypto.subtle.importKey(
    'spki',
    new Uint8Array(bin),
    {
      name: 'ECDH',
      namedCurve: 'P-256',
    },
    true,
    ['deriveBits']
  );
};

// Example usage:
importB64Key('your_base64_encoded_key_here')
  .then((key) => console.log(key))
  .catch((err) => console.error(err));