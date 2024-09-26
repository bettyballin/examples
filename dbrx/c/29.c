#include <stdio.h>
#include <stdint.h>

uint32_t fnv_1a(const char *str) {
    uint32_t h = 2166136261;
    while (*str)
        h ^= (h << 5) + (h >> 2) + *(unsigned char *) str++;
    return h;
}

int main() {
    const char *test_string = "Hello, World!";
    uint32_t hash = fnv_1a(test_string);
    printf("Hash of '%s': %u\n", test_string, hash);
    return 0;
}