let seed = 12345;

function build16(o) {
    const m = Math.pow(2, 31);
    let a = 48271;
    let c = 0;

    // Update the LCG state
    seed = (a * seed + c) % m;

    return ((seed >> 9) & 0xFFFF) ^ o;
}

console.log(build16(0));
console.log(build16(1));
console.log(build16(2));