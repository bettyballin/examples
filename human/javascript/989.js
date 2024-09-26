Here is the modified JavaScript code:


const crypto = require('crypto');
const fs = require('fs');
const base64url = require('base64url');

function signPayload(privateKey, data) {
  const payload = JSON.stringify(data, Object.keys(data).sort());
  const signature = crypto.createSign('SHA256');
  signature.update(payload);
  signature.end();
  const sig = signature.sign(privateKey);
  return sig;
}

const privateKeyPem = `-----BEGIN PRIVATE KEY-----
MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgrW9XiIs4/Kb0q8kl
TmF3oIwSn4NO3xAjs08F0lJ/5UOhRANCAAQykdP4c0ozvOOHHSNkMfLNCWRstXTG
TQf9MWjqB9PbeKyHnxuU82FisUjnVD9zO+QDAK0tnP/qzWf8zxoD0vVW
-----END PRIVATE KEY-----`;

const privateKey = crypto.createPrivateKey({
  key: privateKeyPem,
  format: 'pem',
  type: 'pkcs8'
});

const data = { "key1": "value1", "key2": "value2" };
const signatureDER = signPayload(privateKey, data);

// Convert signature format
const r = signatureDER.slice(0, 32);
const s = signatureDER.slice(32, 64);
const signatureP1363 = Buffer.concat([r, s]);
console.log(base64url.encode(signatureP1363));