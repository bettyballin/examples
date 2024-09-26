#include <stdio.h>
#include <stdint.h>

void lfsr_fi(uint32_t start_state) {
    uint32_t period = 1;

    do {
        // Calculate the new bit based on polynomial
        uint32_t bit = ((start_state >>  7) ^ (start_state >>  8)
                      ^ (start_state >>  9) ^ (start_state >> 10)
                      ^ (start_state >> 11) ^ (start_state >> 12)
                      ^ (start_state >> 13) ^ (start_state >> 14)
                      ^ (start_state >> 15) ^ (start_state >> 16)
                      ^ (start_state >> 17) ^ (start_state >> 20)
                      ^ (start_state >> 23)) & 1u;

        // Update the LFSR state
        start_state = ((start_state >>  1) | (bit << 23));

        printf("%08x\n", start_state);
        period++;
    } while (start_state != 0x00000001 && period < 0xffffffff);
}

int main() {
    lfsr_fi(0x00000001);
    return 0;
}