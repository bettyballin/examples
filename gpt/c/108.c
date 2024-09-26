
#include <stdint.h>
#include <stdio.h>
#include <math.h>

uint64_t rc(int t) {
    if (t % 255 == 0) {
        return 0x1;
    }

    uint64_t R = 0x1;
    for (int i = 1; i < t % 255; ++i) {
        // Shift R left by one (dropping the leftmost bit)
        R <<= 1;
        
        // Perform the linear feedback
        uint8_t feedback = (R >> 8) ^ (R >> 0); // Same as (R >> 0)
        if (feedback & 1) {
            R ^= 0x71; // Feedback polynomial: x^8 + x^6 + x^5 + x^4 + 1
        }
        
        // Keep only the lower 8 bits
        R &= 0xFF;
    }

