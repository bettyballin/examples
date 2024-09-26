const CryptoJS = require("crypto-js");

const key = CryptoJS.lib.WordArray.create([
  756835, 1022419, 54965, 19690815,
  22211841, 189582737, 177843360
]);

console.log(key);