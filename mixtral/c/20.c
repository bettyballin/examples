#include <stdint.h>
#include <stdio.h>

uint8_t copyMSB(uint8_t x) {
    uint8_t mask = 0x80; // MSB

    return (mask & -((x >> 7) ^ 1));
}

int main() {
    uint8_t x = 0x12;
    printf("%x\n", copyMSB(x));
    return 0;
}