const crypto = require('crypto');
const base64url = require('base64url');

const publikKeyDer = base64url.toBuffer("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEWzC5lPNifcHNuKL+/jjhrtTi+9gAMbYui9Vv7TjtS7RCt8p6Y6zUmHVpGEowuVMuOSNxfpJYpnGExNT/eWhuwQ==");
const data = {
  "data_1": "The quick brown fox",
  "data_2": "jumps over the lazy dog"
};
const signature = base64url.toBuffer("XRNTbkHK7H8XPEIJQhS6K6ncLPEuWWrkXLXiNWwv6ImnL2Dm5VHcazJ7QYQNOvWJmB2T3rconRkT0N4BDFapCQ==");

const publicKey = crypto.createPublicKey({
  key: publikKeyDer,
  format: 'der',
  type: 'spki'
});

const r = BigInt(`0x${signature.slice(0, 32).toString('hex')}`);
const s = BigInt(`0x${signature.slice(32).toString('hex')}`);

const verify = crypto.createVerify('SHA256');
verify.update(JSON.stringify(data));
verify.end();

try {
  if (verify.verify(publicKey, Buffer.concat([r.toString(16).padStart(64, '0'), s.toString(16).padStart(64, '0')], 64))) {
    console.log("verification succeeded");
  } else {
    console.log("verification failed");
  }
} catch (err) {
  console.log("verification failed");
}