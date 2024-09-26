function clone(obj) {
  return JSON.parse(JSON.stringify(obj));
}

var x = JSON.parse('{\"a\": 1, \"b\": {\"c\": 2, \"__proto__\": { \"foo\": 10 } }}');
console.log(x);
var y = clone(x);
console.log(y);
var z = {};
console.log(z.foo); // undefined (no pollution)