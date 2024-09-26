
#include <stdio.h>
#include <stdint.h>

// xorshift function
uint64_t xorshift(uint64_t f) {
    f ^= f << 13;
    f ^= f >> 7;
    f ^= f << 17;
    return f;
}

// foo function
uint64_t foo(uint64_t j) {
    int k = 4;
    for (int i = 0; i < k; i++) {
