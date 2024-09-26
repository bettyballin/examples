
#include <stdint.h>
#include <stdio.h>

void lfsr_fib(uint32_t start_state) {
    uint32_t lfsr = start_state;
    uint32_t period = 0;
    uint32_t bit;

    do {
        // polynomial: x^24 + x^23 + x^22 + x^20 + x^19 + x^18 + x^17 + x^16 + x^15 + x^13 + x^12 + x^8 + x^7 + x^6 + 1

        bit = ((lfsr >> 0) ^ (lfsr >> 1) ^ (lfsr >> 2) ^ (lfsr >> 4) ^ (lfsr >> 5
