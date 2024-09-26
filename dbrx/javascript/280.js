(async () => {
  const message = "(query params from an url)";
  const given_signature = "(extracted from the query params)";
  const SECRET = "...";

  const algorithm = { name: 'HMAC', hash: 'SHA-256' };
  const encoder = new TextEncoder();

  const key = await crypto.subtle.importKey(
    'raw',
    encoder.encode(SECRET),
    algorithm,
    false,
    ['sign', 'verify']
  );

  const signatureBuffer = await crypto.subtle.sign(
    algorithm,
    key,
    encoder.encode(message)
  );

  // Convert the given_signature to ArrayBuffer
  const decoder = new TextDecoder('ascii');
  const givenSignatureArrayBuffer = new Uint8Array(given_signature.match(/.{1,2}/g).map(byte => parseInt(byte, 16)));

  // Compare ArrayBuffers directly
  const isVerified = await crypto.subtle.verify(
    algorithm,
    key,
    givenSignatureArrayBuffer,
    signatureBuffer
  );

  console.log(isVerified);
})();