const crypto = require('crypto');

const hashstr = "your_hash_string";
const challenge = "your_challenge_string";

const hmac1 = crypto.createHmac('sha1', hashstr);
hmac1.update(challenge);
console.log(hmac1.digest());