const publicKey = `-----BEGIN CERTIFICATE-----
MIIDdTCCAl2gAwIBAgIVAMIIujU9wQibtTryEphysics03Ua9wQibtTryEphysics03Ua9wQ==
-----END CERTIFICATE-----`;

const publicKeyWithoutNewlines = publicKey.replace(/\n/g, '').replace(/\\n/g, '').replace(/\r/g, '').replace(/\\r/g, '');
console.log(publicKeyWithoutNewlines);