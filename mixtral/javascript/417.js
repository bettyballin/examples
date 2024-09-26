const crypto = require('crypto');
const TextEncoder = require('util').TextEncoder;

async function verify(user) {
  const secret = await crypto.subtle.importKey(
    "raw",
    new TextEncoder().encode(process.env.SECRET),
    {
      name: "HMAC",
      hash: {name: 'SHA-256'}
    },
    false,
    ["verify"]
  );

  const decodedSignature = Buffer.from(user.split('.')[2], 'base64url');

  return crypto.subtle.verify("HMAC", secret, new Uint8Array(decodedSignature), new TextEncoder().encode(`${user.split('.').slice(0, -1).join('.')}`));
}

// Example usage:
process.env.SECRET = "your_secret_key";
verify("your_user_token").then(result => console.log(result));