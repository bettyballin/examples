(async () => {
  const publicKeyJWKObject = {
    kty: "RSA",
    e: "AQAB",
    n: "your_public_key_n_value",
    alg: "RSA-OAEP",
    ext: true,
  };

  const privateKeyJWKObject = {
    kty: "RSA",
    e: "AQAB",
    n: "your_private_key_n_value",
    d: "your_private_key_d_value",
    p: "your_private_key_p_value",
    q: "your_private_key_q_value",
    dp: "your_private_key_dp_value",
    dq: "your_private_key_dq_value",
    qi: "your_private_key_qi_value",
    alg: "RSA-OAEP",
    ext: true,
  };

  const importedPublicKey = await window.crypto.subtle.importKey(
    'jwk',
    publicKeyJWKObject,
    {
      name: "RSA-OAEP",
      hash: {name: "SHA-256"}
    },
    true,
    ['encrypt']
  );

  const importedPrivateKey = await window.crypto.subtle.importKey(
    'jwk',
    privateKeyJWKObject,
    {
      name: "RSA-OAEP",
      hash: {name: "SHA-256"}
    },
    true,
    ['decrypt']
  );
})();