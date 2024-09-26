#include <stdio.h>
#include <stdint.h>

// xorshift function
uint64_t xorshift(uint64_t* f) {
    *f ^= (*f << 13);
    *f ^= (*f >> 7);
    *f ^= (*f << 17);
    return *f;
}

// foo function
void foo(uint64_t* j, int k) {
    for (int i = 0; i < k; ++i) {
        xorshift(j);
    }
}

int main() {
    uint64_t z = 123456789;
    foo(&z, 4);

    // Now 'z' will hold the final output after applying
    // xor and shift operations for four times.
    printf("%llu\n", z);

    return 0;
}