const BigNumber = require('bignumber.js');

bigZero = BigNumber.from(0);
bigTwo = BigNumber.from(2);
bigThree = BigNumber.from(3);
ellipticCurveB = BigNumber.from(7);
generatorPrime = BigNumber.from("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
baseXCoord = BigNumber.from("0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798");
baseYCoord = BigNumber.from("0x483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8");

// slope = ( (3*x^2) * (2*y)^-1 ) mod order
threeXSquared = bigThree.mul(baseXCoord.pow(bigTwo));
modInv2y = modinv(bigTwo.mul(baseYCoord), generatorPrime);
m = threeXSquared.mul(modInv2y).mod(generatorPrime);

// 2Px = slope^2 - 2*baseXCoord
mSquared = m.pow(bigTwo);
twoXbase = bigTwo.mul(baseXCoord);
TwoPx = (mSquared.sub(twoXbase)).mod(generatorPrime);

// 2Py = slope * ( 2Px - baseXCoord ) - baseYCoord
pointSlopeX = m.mul(TwoPx.sub(baseXCoord)); 
TwoPy = (pointSlopeX).sub(baseYCoord).mod(generatorPrime);

console.log(TwoPx.toString(16));
console.log(TwoPy.toString(16));
console.log(isPointOnCurve(TwoPx, TwoPy));

// Helper Functions:
// Check if point is on Curve, Calculate extended GCD, modular inverse

function isPointOnCurve(x,y){
    b = ellipticCurveB;
    p = generatorPrime;
    rem = (y.pow(bigTwo).sub(x.pow(bigThree)).sub(b)).mod(p);
    return rem.eq(bigZero);
}

function egcd(a, b) {
    var s = BigNumber.from(0), t = BigNumber.from(1), u = BigNumber.from(1), v = BigNumber.from(0);
    while (!a.eq(BigNumber.from(0))) {
        var q = b.div(a), r = b.mod(a);
        var m = s.sub(u.mul(q)), n = t.sub(v.mul(q));
        b = a;
        a = r;
        s = u;
        t = v;
        u = m;
        v = n;
    }
    return [b, s, t];
}

function modulus(x, y) {
    return (x.mod(y).add(y)).mod(y);
}

function modinv(x, y) {
    var tuple = egcd(x.mod(y), y);
    if (!tuple[0].eq(BigNumber.from(1))) {
        return null;
    }
    return modulus(tuple[1], y);
}