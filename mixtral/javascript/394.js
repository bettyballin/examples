const crypto = require('crypto');

let str = "One piece of chocola... slice of watermelon";
let hashBuffer = crypto.createHash("sha256").update(str).digest();

console.log(hashBuffer.toString('hex'));