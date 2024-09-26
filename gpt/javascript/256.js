
const modulus = public_key["n"];
const modulusDecoded = BigInt("0x" + modulus);

console.log(modulusDecoded.toString());

