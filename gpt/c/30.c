++
short gfMultiply(short a, short b) {
    short result = 0;
    short temp = a;

    for (int i = 0; i < 8; i++) {
        // If the LSB of b is set, XOR the result with temp (a shifted left by i
