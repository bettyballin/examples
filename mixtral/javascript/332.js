const Buffer = require('buffer').Buffer;

function derToPem(der) {
  const b64 = Buffer.from(der).toString('base64');

  return `-----BEGIN RSA PUBLIC KEY-----\
${b64.match(/.{1,64}/g).join('\n')}\
-----END RSA PUBLIC KEY-----`;
}

// Test the function
const der = [ /* your DER encoded data here */ ];
console.log(derToPem(der));