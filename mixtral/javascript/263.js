const uint8array = new Uint8Array([68, 75, 57, 107, 110, 43, 55, 107, 108, 84, 50, 72, 118, 53, 65, 54, 119, 82, 100, 115, 82, 101, 65, 111, 51, 120, 89]);
const encodedCorrectly = btoa(String.fromCharCode.apply(null, uint8array));
console.log("encodedCorrectly:", encodedCorrectly);
// Outputs "DK9kn+7klT2Hv5A6wRdsReAo3xY="