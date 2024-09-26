#include <stdio.h>

#define uint8_msb_to_all_bits(x) (0xFF * ((x) >> 7))

int main() {
    uint8_t x = 0x80; // example input
    uint8_t result = uint8_msb_to_all_bits(x);
    printf("%02x\n", result);
    return 0;
}