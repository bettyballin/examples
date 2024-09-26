#include <stdint.h>

uint32_t get_mask(uint64_t a, uint64_t b) {
    uint32_t mask = (uint32_t)(((uint64_t)a - (uint64_t)b) >> 32);
    return mask;
}

int main() {
    uint64_t a = 0x1234567890abcdef;
    uint64_t b = 0x1234567890abcdee;
    uint32_t mask = get_mask(a, b);
    return 0;
}