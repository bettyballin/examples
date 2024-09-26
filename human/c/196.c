#include <stdio.h>
#include <inttypes.h>

uint64_t linear_congruential()
{
    static uint64_t s = 1442695040888963407; // seed
    const uint64_t a = 6364136223846793005; // the multiplier a
    s *= a;
    return s;
}

int main()
{
    printf("%" PRIu64 "\n", linear_congruential());
    return 0;
}