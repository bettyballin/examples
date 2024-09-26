const crypto = require("crypto");
const SECRET = "S3CRET"; // a secret shared by your server and security rules
const filepath = "/path/to/file"; // replace with your file path

// If the user is authenticated, send them this upload token:
const nonce = crypto.randomBytes(9).toString('base64');
const data = `${nonce},${filepath},${SECRET}`
const token = { nonce, hash: crypto.createHash('sha256').update(data).digest('base64') };

console.log(token);