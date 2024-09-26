const crypto = require('crypto');
const AWS = require('aws-sdk');

// Replace with your own values
const accessKeyId = 'YOUR_ACCESS_KEY_ID';
const secretAccessKey = 'YOUR_SECRET_ACCESS_KEY';
const bucketName = 'YOUR_BUCKET_NAME';
const objectKey = 'YOUR_OBJECT_KEY';

// Create an S3 client
const s3Client = new AWS.S3({
  region: 'us-east-1',
  accessKeyId: accessKeyId,
  secretAccessKey: secretAccessKey
});

// Define the policy
const policy = {
  Version: '2012-10-17',
  Statement: [
    {
      Sid: 'EnablePublicReadGetObject',
      Effect: 'Allow',
      Principal: {
        CanonicalUser: accessKeyId
      },
      Action: 's3:GetObject',
      Resource: `arn:aws:s3:::${bucketName}/${objectKey}`
    }
  ]
};

// Generate the policy and signature
const policyBase64 = Buffer.from(JSON.stringify(policy)).toString('base64');
const signature = crypto
  .createHmac('sha256', secretAccessKey)
  .update(policyBase64)
  .digest('base64');

// Usage example
console.log('Policy:', policyBase64);
console.log('Signature:', signature);