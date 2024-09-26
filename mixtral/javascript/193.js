const fs = require('fs');

let cert = fs.readFileSync("path/to/your-certificate.pem", "utf8");

// Convert to base64
const certificateBase64 = Buffer.from(cert).toString('base64');

const crypto = require('crypto');
const subtle = crypto.subtle;

subtle.importKey(
  'spki',
  Buffer.from(certificateBase64, 'base64'),
  {
    name: 'RSASSA-PKCS1-v1_5',
    hash: 'SHA-256'
  },
  true,
  ['verify']
).then(key => {
  console.log(key);
}).catch(err => {
  console.error(err);
});