
function getMessageSignature(path, apiSecret, postData, nonce) {
  // Step 1: Create SHA256 hash of nonce and postData
  var message = nonce + postData;
  var sha256Hash = Utilities.computeDigest(Utilities.DigestAlgorithm.SHA_256, message, Utilities.Charset.UTF_8);

  // Step 2: Base64-decode the apiSecret
  var decodedSecret = Utilities.base64Decode(apiSecret);

  // Step 3: Create path + SHA256 hash
  var pathWithHash = path + Utilities.newBlob(sha256Hash).getBytes();

  // Step 4: Compute HMAC signature using HMAC-SHA512
  var hmacSignature = Utilities.computeHmacSignature(Utilities.MacAlgorithm.HMAC_SHA_512, pathWithHash, decodedSecret);
  
  // Step 5: Base64-encode the HMAC signature
 
