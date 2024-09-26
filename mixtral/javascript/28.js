var crypto = require("crypto");

exports.createS3Policy = function(config, callback) {
  var date = new Date();
  var s3Policy = {
    "expiration": new Date(date.getFullYear(), date.getMonth() + 1, 0),
    "conditions": [
      {"bucket": config.bucket},
      ["starts-with", "$key", ""],
      {"acl": "public-read"},
      ["starts-with", "$Content-Type", ""],
      ["content-length-range", 0, 524288000]
    ]
  };

  const stringPolicy = JSON.stringify(s3Policy);

  const signature = crypto
    .createHmac('sha1', config.secretKey)
    .update(stringPolicy, 'utf-8')
    .digest();

  // Convert the binary digest to base64
  var encodedSignature = Buffer.from(signature).toString("base64");

  const s3Credentials = {
    policy: stringPolicy,
    signature: encodedSignature
  };

  callback(s3Credentials);
};