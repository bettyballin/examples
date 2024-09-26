const crypto = require('crypto');
const psha1 = require('psha1');

function generateSignatureValue({
  clientSecret,
  serverSecret,
  messageToSign,
}) {
  const secretKey = psha1(clientSecret, serverSecret, 256);

  const hash = crypto
    .createHmac('sha1', Buffer.from(secretKey, 'base64'))
    .update(messageToSign)
    .digest('binary');

  return Buffer.from(hash, 'binary').toString('base64');
}

module.exports = generateSignatureValue;