
var publicKey = '-----BEGIN PUBLIC KEY----- ... -----END PUBLIC KEY-----';

var encrypt = new JSEncrypt();
encrypt.setPublicKey(publicKey);
var encrypted = encrypt.encrypt('Text to send.');

// Proper URL encoding
