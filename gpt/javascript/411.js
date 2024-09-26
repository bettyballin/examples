
const CryptoJS = require("crypto-js");

function hmacSHA256(message, key) {
  // Parse the hex strings into CryptoJS words
  const keyWordArray = CryptoJS.enc.Hex.parse(key);
  const messageWordArray = CryptoJS.enc.Hex.parse(message);
  const opadWordArray = CryptoJS.enc.Hex.parse("5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c5c");
  const ipadWordArray = CryptoJS.enc.Hex.parse("3636363636363636363636363636363636363636363636363636363636363636");

  // Ensure
