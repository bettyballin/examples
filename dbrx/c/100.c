#include <stdint.h>

int main() {
    uint32_t shift_table[256];
    for(int i = 0; i < 256; ++i) {
        uint32_t value = (uint32_t)i; // calculate the desired logical shift for 'i'
        shift_table[i] = value;
    }
    return 0;
}