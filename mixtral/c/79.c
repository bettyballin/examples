#include <stdio.h>
#include <stdint.h>

uint64_t rc(int i) {
    uint64_t r = 0x0000000000000001;
    for (int j = 0; j < i; ++j) {
        r = (r << 1) ^ (r >> 63) ^ (r & 1) ? 0x87 : 0;
    }
    return r;
}

int main() {
    for(int i_r = 0; i_r < 24; ++i_r)
    {
        uint64_t RC = 0x0;

        for (size_t j = 0; j <= 5; ++j)
            // Use bitwise shift and XOR operations to calculate the round constant
            RC ^= rc(7 * i_r + j) << ((1ULL << j) - 1);

        printf("%llu\n", RC);
    }
    return 0;
}