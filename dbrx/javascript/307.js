const crypto = require('crypto');
const elliptic  = require('elliptic');
const EC  = elliptic.ec;
const {base16, base64url}  = require('rfc4648');
const BN  = require("bn.js");
const padBase16ToWholeOctets  = s => s.length%2===0 ? s : '0'+s;

console.log('begin'); // forces console output to show from async IIFE

(async () => {
  let keyPair  = await crypto.subtle.generateKey({ name: "ECDSA", namedCurve: "P-521" }, true, ['sign'])
  let jwk  = await crypto.subtle.exportKey("jwk", keyPair.privateKey)
  console.log(jwk)

  const dHex  = base16.parse(padBase16ToWholeOctets(base64url.stringify(jwk.d)))

  const ec  = new EC('p521')
  const [x, y]  = ec.curve.g.mul(dHex).toJSON()

  console.log(`expected x: ` + jwk.x)
  console.log(`actual   x: ` + base16.stringify(x))

  // Encode only the 'y' coordinate in Base64URL format
  let b64Y = base64url.stringify(base16.parse(padBase16ToWholeOctets(y.toString(16))))

  console.log(`expected y: ${jwk.y}`)
  console.log(`actual   y: ` + b64Y)
})();