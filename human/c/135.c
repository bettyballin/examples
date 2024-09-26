#include <stdio.h>
#include <stdint.h>

int main() {
    uint32_t pattern = 0xbb48c031;
    uint32_t* start_addr = (uint32_t*)0x7fffffffe000;
    uint32_t* end_addr = (uint32_t*)__builtin_frame_address(0);
    uint32_t* addr;

    for (addr = start_addr; addr <= end_addr; addr++) {
        if (*addr == pattern) {
            printf("Pattern found at address: %p\n", (void*)addr);
            break;
        }
    }

    if (addr > end_addr) {
        printf("Pattern not found.\n");
    }

    return 0;
}