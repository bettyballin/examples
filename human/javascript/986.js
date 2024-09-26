// Import CryptoJS library
const CryptoJS = require("crypto-js");

// Key is UTF8 encoded 64 bytes -&gt; no padding / no hashing required
const key = "e9058ab198f6908f702111b0c0fb5b36f99d00554521886c40e2891b349dc7a1"
const mess  = "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824";

// Step 1: determine K xor opad (oKeyWA), K xor ipad (iKeyWA)
//
var hasherBlockSizeBytes = 64; // in bytes
var hasherBlockSize = hasherBlockSizeBytes/4; // in words
var keyWA = CryptoJS.enc.Utf8.parse(key);
var oKeyWA = keyWA.clone();
var iKeyWA = keyWA.clone();
var oKeyWords = oKeyWA.words;
var iKeyWords = iKeyWA.words;
for (var i = 0; i < hasherBlockSize; i++) {
    oKeyWords[i] ^= 0x5c5c5c5c;
    iKeyWords[i] ^= 0x36363636;
}

// Step 2: determine P = H( (K xor ipad) || M )
//
var messWA = CryptoJS.enc.Hex.parse(mess); 
var iKeyMessWA = iKeyWA.concat(messWA); 
var iKeyMessHashWA = CryptoJS.SHA256(iKeyMessWA);

// Step 3: determine HMAC = H ( (K xor opad) || P) 
// 
var oKeyiKeyMessHashWA = oKeyWA.concat(iKeyMessHashWA);
var hmacWA = CryptoJS.SHA256(oKeyiKeyMessHashWA);
console.log("HMAC: ", hmacWA.toString(CryptoJS.enc.Hex));

// Comparison with built-in function
var hmacDirectWA = CryptoJS.HmacSHA256(messWA, keyWA);
console.log("HMAC Direct: ", hmacDirectWA.toString(CryptoJS.enc.Hex));