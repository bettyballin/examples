const Buffer = require('buffer').Buffer;

function toBuf(str, encoding) {
  if (typeof str === 'string') {
    if (encoding === 'buffer' || !encoding)
      encoding = 'utf8';
    return Buffer.from(str, encoding);
  }
  return str;
}

console.log(toBuf("Hello, World!", "utf8"));
console.log(toBuf("Hello, World!", "ascii"));
console.log(toBuf("Hello, World!", "buffer"));
console.log(toBuf(Buffer.from("Hello, World!", "utf8"), "utf8"));