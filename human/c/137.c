#include <stdint.h>

int main() {
    uint8_t a0 = 0; // replace with your value
    uint8_t a1 = 0; // replace with your value

    for (int c0 = 0; c0 <= 0xff; c0++)
        for (int c1 = 0; c1 <= 0xff; c1++)
        {
            uint32_t D = (uint32_t)c0<<24|(uint32_t)(a0^c0)<<16|(uint32_t)(a1^c1)<<8|(uint32_t)c1;
            // your code here...
        }
    return 0;
}