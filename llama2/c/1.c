#include <stdint.h>

int32_t GaloisMultiplySquared(int32_t a) {
    int32_t x = a;
    return (x << 1) + (x & 0x40 ? 3 : 0);
}

int main() {
    int32_t a = 10;
    int32_t result = GaloisMultiplySquared(a);
    return 0;
}