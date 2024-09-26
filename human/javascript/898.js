const crypto = require('crypto');

function deriveKey() {
  const serverPkcs8 = `-----BEGIN PRIVATE KEY-----
MIG2AgEAMBAGByqGSM49AgEGBSuBBAAiBIGeMIGbAgEBBDBReGpDVmoVTzxNbJx6
aL4L9z1EdB91eonAmAw7mKDocLfCJITXZPUAmM46c6AipTmhZANiAAR3t96P0ZhU
jtW3rHkHpeGu4e+YT+ufMiMeanE/w8p+d9aCslvIbZyBBzeZ/266yqTUUoiYDzqv
Hb5q8rz7vEgr3DG4XfHYpCqfE2nttQGK3emHKGnvY239AteZkdwMpcs=
-----END PRIVATE KEY-----`;

  const clientX509 = `-----BEGIN PUBLIC KEY-----
MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEm0xeyy3nVnYpOpx/CV/FnlNEdWUZaqtB
AGf7flKxXEjmlSUjseYzCd566sLpNg56Gw6hcFx+rWTLGR4eDRWfmwlXhyUasuEg
mb0BQf8XJLBdvadb9eFx2CP1yjBsiy8e
-----END PUBLIC KEY-----`;

  const clientPublicKey = crypto.createPublicKey({
    key: clientX509,
    format: 'pem',
    type: 'spki'
  });

  const serverPrivateKey = crypto.createPrivateKey({
    key: serverPkcs8,
    format: 'pem',
    type: 'pkcs8'
  });

  const sharedSecret = crypto.diffieHellman({
    privateKey: serverPrivateKey,
    publicKey: clientPublicKey
  });

  console.log('Shared secret: ' + sharedSecret.toString('base64'));

  const derivedKey = crypto.createHmac('sha256', sharedSecret).digest();
  console.log('Derived key:   ' + derivedKey.toString('base64'));
}

deriveKey();