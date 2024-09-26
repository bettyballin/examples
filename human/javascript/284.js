var str = "äöüÄÖÜçéèñ";
var b64 = Buffer.from(encodeURIComponent(str)).toString('base64');
console.log(b64);

var str2 = decodeURIComponent(Buffer.from(b64, 'base64').toString());
console.log(str2);