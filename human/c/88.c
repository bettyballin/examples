#include <stdint.h>
#include <stdio.h>

int main() {
    uint32_t a = 5, b = 10;
    uint32_t mask = -(int32_t)((a - b) >> 31);
    a = ((a + b) & mask) | (a & ~mask);
    printf("%u\n", a);
    return 0;
}