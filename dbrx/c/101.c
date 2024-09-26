#include <stdint.h>

int main() {
    uint8_t key[] = {0x12, 0x34, 0x56, 0x78};
    uint32_t shift_table[] = {0x12345678, 0x23456789, 0x3456789A, 0x456789AB};
    uint8_t some_const = 4;
    uint32_t mask = 0x0000000F;

    uint32_t result = (shift_table[key[3]] >> some_const) & mask;

    return 0;
}