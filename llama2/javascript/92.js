const pem = 'your_pem_key_here';
const km = new KeyManager();
const pkcs8 = km.toPkcs8(pem);

// Now you can import the PKCS#8-formatted key into the browser
window.crypto.subtle.importKey(
  'pkcs8',
  pkcs8,
  {
    name: 'ECDSA',
    namedCurve: 'P-256'
  },
  false,
  ['sign']
).then(function(key) {
  console.log(key);
}).catch(function(err) {
  console.error(err);
});