Here is the executable JavaScript code:


const { ethers } = require('ethers');
const BN = require('bignumber.js');

// Variable initialization found from https://en.bitcoin.it/wiki/Secp256k1
const bigZero = new BN(0);
const bigTwo = new BN(2);
const bigThree = new BN(3);
const ellipticCurveB = new BN(7);
const generatorPrime = new BN("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
const order = new BN("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
const baseXCoord = new BN("0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798");
const baseYCoord = new BN("0x483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8");

// Slope  = ( (3*x^2) * (2*y)^-1 ) mod order
// TwoPx  = slope^2 - 2*baseXCoord
// TwoPy  = slope * (TwoPx - baseXCoord) - baseYCoord

let m = new BN(0);
try {
    m = bigThree.mul(baseXCoord.pow(bigTwo)).mul(modinv(new BN(2).mul(baseYCoord), order));
} catch (e) {
    console.error("Error calculating modular inverse:", e.message);
}

const TwoPx = m.pow(bigTwo).sub(new BN(2).mul(baseXCoord)).mod(order);
const TwoPy = new BN(m.mul(TwoPx.sub(baseXCoord))).sub(baseYCoord).mod(order);

console.log(TwoPx.toString(16));
console.log(TwoPy.toString(16));

// Helper Functions:
// Check if point is on Curve Calculate extended GCD modular inverse

function modinv(x, y) {
    const tuple = egcd(x, y);
    return new BN(tuple[1]);
}

function egcd(a, b) {
    if (a.equals(bigZero)) {
        return [b, bigZero, bigOne];
    } else {
        const [g, x, y] = egcd(b.mod(a), a);
        return [g, y.minus(b.div(a).mul(x)), x];
    }
}

const bigOne = new BN(1);