const CryptoJS = require("crypto-js");

const key    = CryptoJS.enc.Hex.parse("e9058ab198f6908f702111b0c0fb5b36f99d00554521886c40e2891b349dc7a1");
const ipad   = CryptoJS.enc.Hex.parse("3636363636363636363636363636363636363636363636363636363636363636");
const opad   = CryptoJS.enc.Hex.parse("5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c");
const mess   = "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824";

const alpha = xorWordArray(key, opad);
const beta  = xorWordArray(key, ipad);

function xorWordArray(a, b) {
  const result = CryptoJS.lib.WordArray.create();
  for (let i = 0; i < a.words.length; i++) {
    result.words[i] = a.words[i] ^ b.words[i];
  }
  return result;
}

console.log(alpha.toString(CryptoJS.enc.Hex));
console.log(beta.toString(CryptoJS.enc.Hex));