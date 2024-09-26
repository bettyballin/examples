const b64ToBin = (base64) => {
  const raw = atob(base64);
  const array = new Uint8Array(new ArrayBuffer(raw.length));
  for (let i = 0; i < raw.length; i++) {
    array[i] = raw.charCodeAt(i);
  }
  return array;
};

const importB64Key = async (base64key) => {
  const bin = b64ToBin(base64key);
  console.log('bin:', bin);
  const publicKey = await window.crypto.subtle.importKey(
    'raw',
    bin,
    {
      name: 'ECDH',
      namedCurve: 'P-256',
    },
    true,
    ['deriveKey']
  );

  const privateKey = await window.crypto.subtle.importKey(
    'raw',
    bin,
    {
      name: 'ECDH',
      namedCurve: 'P-256',
    },
    true,
    ['deriveKey']
  );

  console.log('Public Key:', publicKey);
  console.log('Private Key:', privateKey);
};

// Test the function
importB64Key('your_base64_encoded_key_here');