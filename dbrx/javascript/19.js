const Buffer = require('buffer').Buffer;

var s3Policy = {
  "expiration": "2024-01-01T12:00:00.000Z",
  "conditions": [
    {"bucket": "my-bucket"},
    ["starts-with", "$key", "uploads/"],
    {"acl": "private"},
    ["starts-with", "$Content-Type", ""],
    ["content-length-range", 0, 1048576]
  ]
};

var stringPolicy = Buffer.from(JSON.stringify(s3Policy), "utf16le").toString();
console.log(stringPolicy);