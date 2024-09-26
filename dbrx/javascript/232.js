window.crypto.subtle.generateKey(
  {
    name: "RSA-OAEP",
    modulusLength: 2048, // can be 1024, 2048 or 4096
    publicExponent: new Uint8Array([1, 0, 1]), // 65537 default value
    hash: {name: "SHA-256"} // can be "SHA-1", "SHA-224", "SHA-384", or "SHA-512"
  },
  true,
  ["encrypt", "decrypt"]
)
.then(function(key){
  console.log(key);
})
.catch(function(err){
  console.error(err);
});