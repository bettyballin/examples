const crypto = window.crypto || window.msCrypto;

crypto.subtle.generateKey(
  {
    name: "ECDH",
    namedCurve: "P-256", // can be "P-256", "P-384", or "P-521"
    public: true, // whether the key is public
    private: true // whether the key is private
  },
  true, // whether the key is extractable (i.e. can be used in exportKey)
  ["deriveKey", "deriveBits"] // can be any combination of 'deriveKey' and 'deriveBits'
).then(function(key) {
  return Promise.all([
    crypto.subtle.exportKey('raw', key.publicKey),
    crypto.subtle.exportKey('pkcs8', key.privateKey)
  ]);
})
.then(([publicKey, privateKey]) => {
  publicKey = new Uint8Array(publicKey);
  privateKey = new Uint8Array(privateKey);

  console.log("Public Key:", publicKey.toString());
  console.log("Private Key:", privateKey.toString());

  // Now you can use these keys as needed
})
.catch(function(err) {
  console.error(err);
});