#include <stdio.h>
#include <stdint.h>

uint64_t a = 6364136223846793005; // a large prime number

uint64_t linear_congruential()
{
    static uint64_t s = 1442695040888963407; // seed
    const uint64_t m = (uint64_t)1 << 64;

    s *= a;
    s = (s >= m) ? s - m : s;

    return s;
}

int main() {
    printf("%llu\n", linear_congruential());
    return 0;
}