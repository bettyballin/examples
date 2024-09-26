const payload = "hello";
var derived_key = CryptoJS.enc.Base64.parse("LefjQ2pEXmiy/nNZvEJ43i8hJuaAnzbA1Cbn1hOuAgA=");
var iv = CryptoJS.enc.Utf8.parse("1020304050607080");
var test = CryptoJS.AES.encrypt(payload, derived_key, { iv: iv, mode: CryptoJS.mode.CBC }).toString();
console.log(test); // Output: bLdmGA+HLLyFEVtBEuCzVg==