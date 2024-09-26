const crypto = require('crypto');
const base64url = require('base64url');

let userid = 55;
let superid = "q322q23";
let dataToHash = `${userid}${superid}`;
let hashedData = crypto.createHash('md5').update(dataToHash).digest("hex");
let websafeEncodedHashedData = base64url(hashedData);

console.log(websafeEncodedHashedData);