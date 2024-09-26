const public_key = { "n": "some_hex_value" };
const modulus = public_key["n"];
const buffer = Buffer.from(modulus, "hex");
const decodedModulus = BigInt("0x" + buffer.toString('hex'));
console.log(decodedModulus);