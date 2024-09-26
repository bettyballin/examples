function main() {
  var apiKey = "API-KEY";
  var apiSecret = "API-SECRET";

  var url = "https://api.kraken.com/0/private/Balance";
  var path = "/0/private/Balance";

  const nonce = new Date().getTime() * 1000;

  const payload = { 'nonce': nonce };
  const postData = 'nonce=' + nonce;
  const secretBuffer = Utilities.base64Decode(apiSecret);

  const signature = getMessageSignature(path, secretBuffer, postData, nonce);

  var httpOptions = {
    'method': 'post',
    'headers': {
      "API-Key": apiKey,
      "API-Sign": signature
    },
    'payload': postData
  };

  var response = UrlFetchApp.fetch(url, httpOptions);
  Logger.log(response.getContentText());
}

function getMessageSignature(url, secretBuffer, data, nonce) {
  const hash = Utilities.computeDigest(Utilities.DigestAlgorithm.SHA_256, (nonce + data).getBytes()).map(e => String.fromCharCode(e)).join('');
  const hmac_digest = Utilities.computeHmacSignature(Utilities.MacAlgorithm.HMAC_SHA_512, (url + hash).getBytes(), secretBuffer);
  return Utilities.base64Encode(hmac_digest);
}