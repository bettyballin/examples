const crypto = require('crypto');
const TextEncoder = require('util').TextEncoder;

async function verify(user) {
  const secret = await crypto.subtle.importKey(
    "raw",
    new TextEncoder().encode(process.env.SECRET),
    {
      name: "HMAC",
      hash: { name: "SHA-256" },
    },
    false,
    ["verify"]
  );

  return crypto.subtle.verify(
    "HMAC",
    secret,
    Buffer.from(user.split(".")[2], "base64url"),
    new TextEncoder().encode(user.split(".").splice(0, 2).join("."))
  );
}

// Usage:
verify("your_user_string").then(result => console.log(result));