const jwt = require('jsonwebtoken');

async function verifyToken(id_token, cert) {
    const decoded = jwt.decode(id_token, { complete: true });
    const payload = decoded.payload;
    const signature = decoded.signature;

    // Verify the signature
    const verified = await jwt.verify(id_token, cert);
    return verified;
}

// Example usage:
const id_token = 'your_id_token_here';
const cert = 'your_cert_here';
verifyToken(id_token, cert).then((verified) => console.log(verified));