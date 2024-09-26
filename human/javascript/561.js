function removePFXComments(pem) {
    let lines = pem.split('\n');
    let encoded = '';
    for (let i = 0; i < lines.length; i++) {
        if (lines[i].trim().length > 0 &&
            lines[i].indexOf('-----BEGIN CERTIFICATE-----') < 0 &&
            lines[i].indexOf('-----END CERTIFICATE') < 0 &&
            lines[i].indexOf('-----BEGIN RSA PRIVATE KEY-----') < 0 &&
            lines[i].indexOf('-----BEGIN RSA PUBLIC KEY-----') < 0 &&
            lines[i].indexOf('-----BEGIN PUBLIC KEY-----') < 0 &&
            lines[i].indexOf('-----END PUBLIC KEY-----') < 0 &&
            lines[i].indexOf('-----BEGIN PRIVATE KEY-----') < 0 &&
            lines[i].indexOf('-----END PRIVATE KEY-----') < 0 &&
            lines[i].indexOf('-----END RSA PRIVATE KEY-----') < 0 &&
            lines[i].indexOf('-----END RSA PUBLIC KEY-----') < 0) {
            encoded += lines[i].trim();
        }
    }
    return encoded;
}

function b64ToBinary(base64) {
  let raw = atob(base64);
  let rawLength = raw.length;
  let array = new Uint8Array(new ArrayBuffer(rawLength));

  for(let i = 0; i < rawLength; i++) {
    array[i] = raw.charCodeAt(i);
  }
  return array;
}

// Test the functions
let pem = `-----BEGIN CERTIFICATE-----
MIIDdTCCAl2gAwIBAgIVAMIIujU9wQibtTryEphysics03Ua9wQibtTryEphysics03Ua9wQ==
-----END CERTIFICATE-----`;

let encoded = removePFXComments(pem);
let binary = b64ToBinary(encoded);

console.log(encoded);
console.log(binary);