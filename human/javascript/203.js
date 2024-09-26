const crypto = require("crypto");
const config = require("./amazonConfig.json");

function createS3Policy(contentType) {
  const date = new Date();

  const s3Policy = {
    "expiration": new Date(date.getTime() + 60000).toISOString(), // 1 minute from now
    "conditions": [
      ["starts-with", "$key", "somefolder/"], 
      {"bucket": "my-bucket-name"}, 
      {"acl": "public-read"}, 
      ["starts-with", "$Content-Type", contentType],
      {"success_action_redirect": "http://example.com/uploadsuccess"},
    ]
  };

  // stringify and encode the policy
  const stringPolicy = JSON.stringify(s3Policy);
  const base64Policy = Buffer.from(stringPolicy, "utf-8").toString("base64");

  // sign the base64 encoded policy
  const signature = crypto.createHmac("sha1", config.secretKey)
    .update(Buffer.from(base64Policy, "utf-8")).digest("base64");

  // build the results object
  const s3Credentials = {
    s3Policy: base64Policy,
    s3Signature: signature
  };

  return s3Credentials;
}

// usage
const contentType = "image/jpeg";
const s3Credentials = createS3Policy(contentType);
console.log(s3Credentials);