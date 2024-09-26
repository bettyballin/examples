
function encrypt() {
    var key = CryptoJS.enc.Hex.parse('48656c6c6f2c20576f726c6421888888');
    var IVLEN = 16; // AES block size in bytes
    var iv = CryptoJS.lib.WordArray.random(IVLEN);
    var message = "1234";
    var messageWords = CryptoJS.enc.Utf8.parse(message);
    var paddedMessageWords = padMessageToBlockSize(messageWords, IVLEN);
    var encrypted = CryptoJS.AES.encrypt(paddedMessageWords, key, { iv: iv, padding: CryptoJS.pad.NoPadding, mode: CryptoJS.mode.CBC });

    var encryptedHex =
