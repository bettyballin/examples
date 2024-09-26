const bigIntMaxValue = 0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffn;
const baseXCoord = 0x04n;
const baseYCoord = 0x04n;
const generatorPrime = 0xfffffffffffffffffffffffffffffffebaadae4af48a03bbfd25e8cd0364141n;

function modinv(a, m) {
  a %= m;
  for (let x = 1n; x < m; x++) {
    if ((a * x) % m === 1n) return x;
  }
  return 1n;
}

function mod(a, m) {
  let result = a % m;
  if (result < 0n) {
    result += m;
  }
  return result;
}

const bigThree = 3n;
const bigTwo = 2n;

const m = modinv(bigThree * (baseXCoord ** bigTwo) / 2n, generatorPrime);
const TwoPx = mod((m ** bigTwo) - 2n * baseXCoord, generatorPrime);
const TwoPy = mod(m * (TwoPx - baseXCoord) - baseYCoord, generatorPrime);

console.log(m.toString(16));
console.log(TwoPx.toString(16));
console.log(TwoPy.toString(16));