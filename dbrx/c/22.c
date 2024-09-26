#include <stdint.h>
#include <stdio.h>

uint8_t constant_time_msb_to_all_bits(uint8_t input) {
    uint8_t msb = (input & 0x80); // Extract the MSB by performing bitwise AND with 10000000 in binary.
    return ((msb - 1) >> 7) * (-1);
}

int main() {
    uint8_t input = 0x81; // Example input
    uint8_t result = constant_time_msb_to_all_bits(input);
    printf("%02x\n", result);
    return 0;
}