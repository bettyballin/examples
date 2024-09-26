
function encrypt(signedCert, msg) {
    var key = new RSAKey();
    // n and e retrieved from the digital certificate
    key.setPublic(signedCert.msg.subject.pk.n, signedCert.msg.subject.pk.e);

    var chunkSize = (key.n.bitLength() + 7) >> 3 - 11; // RSA key length in bytes - 11 for PKCS#1 padding
    var chunks = splitMessageIntoChunks(msg, chunkSize);

    var ctxt = "";
    for (var i = 0; i
