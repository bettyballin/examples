const RNG_MULTIPLIER = 0x5DEECE66Dn;
const RNG_ADDEND = 0xBn;
const RNG_MASK = (1n << 48n) - 1n;
const RNG_DSCALE = 1n << 53n;

let rngState = 0n;

function random_next(bits) {
  let nextstate = (rngState * RNG_MULTIPLIER) + RNG_ADDEND;
  nextstate &= RNG_MASK;
  rngState = nextstate;
  return nextstate >> (48n - BigInt(bits));
}

function random_nextDouble() {
  return Number((random_next(26) << 27n) + random_next(27)) / Number(RNG_DSCALE);
}

// Test the functions
console.log(random_nextDouble());