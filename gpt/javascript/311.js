
function goog_crypto(string_to_sign, secret) {
    const hmac = new goog.crypt.Hmac(new goog.crypt.Sha1(), goog.crypt.stringToByteArray(secret), 64 /* block size for SHA-1 */);
    const hash = hmac.getHmac(goog.crypt.stringToByteArray(forceUnicodeEncoding(string_to_sign)));

    // Convert the hash (byte array) to base64
    const base64Hash = goog.crypt.byteArrayToBase64(hash);
    return base64Hash;
}

