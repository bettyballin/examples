let a = 1; // replace with your value
let b = 2; // replace with your value

let c = (a ^ b) & 4294967295;
if (c > 2147483647) {
  c -= 4294967296;
}

console.log(c);