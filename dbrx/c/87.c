#include <stdio.h>

typedef unsigned long long uint64_t;

int main() {
    uint64_t result = linear_congruential();
    printf("Random number: %llu\n", result);

    double result_d = linear_congruential_d();
    printf("Random double: %f\n", result_d);

    return 0;
}

uint64_t linear_congruential() {
    unsigned long long s = 1442695040888963407; // seed
    unsigned long long m = (unsigned long long)1 << 64; // The Modulus 2^64
    unsigned long long a = 6364136223846793005; // the multiplier a

    s *= a;
    if (s >= m)
        s -= m;

    return (uint64_t)s;
}

double linear_congruential_d() {
    double q;
    unsigned long long s = 1442695040888963407; // seed
    unsigned long long m = (unsigned long long)1 << 64; // The Modulus 2^64
    unsigned long long a = 6364136223846793005; // the multiplier a

    s *= a;
    if (s >= m)
        s -= m;

    q = ((double)s / m);
    return q;
}