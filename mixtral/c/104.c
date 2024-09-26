#include <stdint.h>

double linear_congruential_d()
{
    uint64_t a = 1664525; // multiplier
    uint64_t s = 1442695040888963407; // seed
    const uint64_t m = (uint64_t)1 << 64;

    while ((s *= a) >= m) {
        s -= m;
    }

    return (double)s / (m - 1);
}

int main() {
    double result = linear_congruential_d();
    return 0;
}