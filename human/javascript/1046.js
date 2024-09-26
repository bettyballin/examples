const CryptoJS = require("crypto-js");

enc = function (a) {
    var keyBytes = CryptoJS.PBKDF2('lrvq/wyDf6tqhxvg8NuIDQ==', 'Ivan Medvedev', { keySize: 48 / 4, iterations: 1000 });
    var key = new CryptoJS.lib.WordArray.init(keyBytes.words, 32);
    var iv = new CryptoJS.lib.WordArray.init(keyBytes.words.splice(32 / 4), 16);
    var data = CryptoJS.enc.Utf16LE.parse(a);
    var encrypted = CryptoJS.AES.encrypt(data, key, { iv: iv });
    console.log(encrypted.toString());
}
enc("Cat");