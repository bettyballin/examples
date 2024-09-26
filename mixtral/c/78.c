#include <stdint.h>
#include <stdio.h>

uint64_t rc(int t)
{
    if (t % 255 == 0 && t != 0)
        return 1;

    uint8_t R = 1;

    for (int i = 1; i <= t % 255; ++i)
    {
        // Perform bitwise shift and XOR operations
        int feedback = ((R >> 7) ^ (R >> 6)) & 0x01;

        R <<= 1;

        if(feedback == 1)
            R ^= 0b00000010;
    }

    return (uint64_t)R;
}

int main() {
    printf("%llu\n", rc(10));
    return 0;
}