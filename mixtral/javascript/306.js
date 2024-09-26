let seed = 12345; // some initial value

function build8(o) {
    const m = Math.pow(2, 31);
    let a = 48271;
    let c = 0;

    // Update the LCG state
    seed = (a * seed + c) % m;

    return ((seed >> 23) & 0xFF) ^ o;
}

console.log(build8(0));