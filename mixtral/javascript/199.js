async function generateSignature(nonce, secretKey) {
  const encoder = new TextEncoder();

  // Import key
  let importedSecret;

  try {
    importedSecret = await crypto.subtle.importKey(
      'raw',
      encoder.encode(secretKey),
      { name: 'HMAC', hash: 'SHA-256' },
      false,
      ['sign']
    );
  } catch (error) {
    console.log(`Error importing secret key: ${error}`);
    return;
  }

  // Sign nonce
  let signature = await crypto.subtle.sign('HMAC', importedSecret, encoder.encode(nonce));

  // Convert ArrayBuffer to Base64
  const base64Signature = btoa([...new Uint8Array(signature)].map((byte) => String.fromCharCode(byte)).join(''));

  return base64Signature;
}

// Usage
let nonce = 1518440585425;
let secretKey = '9IeVA...h4=';

generateSignature(nonce.toString(), secretKey).then((signature) => {
  console.log(`Generated signature: ${signature}`);
});