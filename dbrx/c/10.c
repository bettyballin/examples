#include <stdint.h>
#include <stdio.h>

#define NN 312
#define MM 156
#define MATRIX_A UINT64_C(0xB5026F5AA96619E9)
#define UM UINT64_C(0xFFFFFFFF80000000) /* Most significant 33 bits */
#define LM UINT64_C(0x7FFFFFFF)         /* Least significant 31 bits */

static uint64_t mt[NN];
static int mti = NN + 1;

void init_genrand(uint64_t seed)
{
    mt[0] = seed;
    for (mti = 1; mti < NN; mti++)
        mt[mti] = (6364136223846793005ULL * (mt[mti - 1] ^ (mt[mti - 1] >> 62)) + mti);
}

uint64_t genrand_int63(void)
{
    uint64_t y;
    static const uint64_t mag01[2] = {0, MATRIX_A};

    if (mti >= NN) {
        int kk;

        for (kk = 0; kk < NN - MM; kk++) {
            y = (mt[kk] & UM) | (mt[kk + 1] & LM);
            mt[kk] = mt[kk + MM] ^ (y >> 1) ^ mag01[y & UINT64_C(1)];
        }
        for (; kk < NN - 1; kk++) {
            y = (mt[kk] & UM) | (mt[kk + 1] & LM);
            mt[kk] = mt[kk + MM - NN] ^ (y >> 1) ^ mag01[y & UINT64_C(1)];
        }
        y = (mt[NN - 1] & UM) | (mt[0] & LM);
        mt[NN - 1] = mt[MM - 1] ^ (y >> 1) ^ mag01[y & UINT64_C(1)];

        mti = 0;
    }

    y = mt[mti++];

    /* Tempering */
    y ^= (y >> 29) & UINT64_C(0x5555555555555555);
    y ^= (y << 17) & UINT64_C(0x71D67FFFEDA60000);
    y ^= (y << 37) & UINT64_C(0xFFF7EEE000000000);
    y ^= (y >> 43);

    return y;
}

int main() {
    init_genrand(19650218);
    for (int i = 0; i < 10; i++) {
        printf("%llu\n", genrand_int63());
    }
    return 0;
}