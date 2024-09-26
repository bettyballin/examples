
const { ethers } = require('ethers');

// Secp256k1 parameters
const p = ethers.BigNumber.from("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
const a = ethers.BigNumber.from(0); // Coefficient a of the curve equation
const b = ethers.BigNumber.from(7); // Coefficient b of the curve equation

// Base point (generator)
const Gx = ethers.BigNumber.from("0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798");
const Gy = ethers.BigNumber.from("0x483ADA7726A3C4655DA4FBFC0E
