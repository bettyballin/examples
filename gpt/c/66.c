
#include <stdint.h>

uint32_t murmur3_32(const char *key, uint32_t len, uint32_t seed) {
    uint32_t h = seed;
    uint32_t c1 = 0xcc9e2d51;
