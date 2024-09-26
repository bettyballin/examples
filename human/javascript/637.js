function ordA(char) {
  return char.charCodeAt(0) - 65;
}

let a = 'A';
let b = 'B';
let decode = false;

console.log(String.fromCharCode((ordA(a) + (decode ? 26 - ordA(b) : ordA(b))) % 26 + 65));