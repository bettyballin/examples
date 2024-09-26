const fetch = (x, o) => {
  if (x >= o) {
    return x
  } else {
    const v = (x * x) % o
    return (x <= o / 2) ? v : o - v
  }
}

const fetch16 = (x) => fetch(x, 65519)
const fetch8 = (x) => fetch(x, 251)

const build16 = (x, o) => fetch16((fetch16(x) + o) % 65536 ^ 42703)
const build8 = (x, o) => fetch8((fetch8(x) + o) % 256 ^ 101)

const j = 115;
let i = 0
let invalid = [];
let valid = new Set;
while (i <= 255) {
    let x = build8(i, j);
    if (x > 255) {
        invalid.push([ i, j, x ]);
    } else {
        valid.add(x);
    }
    i++;
}

console.log("invalid:", JSON.stringify(invalid));
console.log("count of valid:", valid.size);