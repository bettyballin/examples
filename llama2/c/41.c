#include <stdint.h>

#define ROTL8(x) ((x << 1) | (x >> 7))

int main() {
    uint8_t b = 0x01;
    uint8_t b1 = 0x02;
    uint8_t b2 = 0x03;
    uint8_t b3 = 0x04;
    uint8_t b4 = 0x05;

    uint8_t s = b ^ (ROTL8(b1) ^ ROTL8(b2) ^ ROTL8(b3) ^ ROTL8(b4));

    return 0;
}