#include <stdio.h>

#define uint8_msb_to_all_bits(x) (-((x) >> 7))

int main() {
    uint8_t x = 0x80; // example input
    printf("%d\n", uint8_msb_to_all_bits(x));
    return 0;
}