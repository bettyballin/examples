const hashing = require('crypto');

function verifyHash(request, path){
  let nonce = request.resource.metadata.nonce;
  let hash = request.resource.metadata.hash;
  let hash2 = hashing.createHash('sha256').update(nonce + "," + path + ",S3CRET").digest('base64');
  return hash === hash2;
}

const request = {
  resource: {
    metadata: {
      nonce: "1234567890",
      hash: "your_hash_here"
    }
  }
};

const allPaths = "**";
if (verifyHash(request, allPaths)) {
  console.log("Write access granted");
} else {
  console.log("Write access denied");
}