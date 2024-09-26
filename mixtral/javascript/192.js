const fs = require('fs');

let pkcs8key = fs.readFileSync("path/to/your-private-key.pem", "utf8");

XAdES.Application.crypto.subtle
  .importKey(
    "pkcs8",
    Buffer.from(pkcs8key, 'base64'),
    {
      name: "RSASSA-PKCS1-v1_5",
      hash: {name: "SHA-256"}
    },
    false,
    ["sign"]
  );