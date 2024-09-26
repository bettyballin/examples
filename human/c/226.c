#include <stdio.h>
#include <stdint.h>

#define B(_s) \
    ((lfsr >> _s) & 1u)

void
lfsr_fib(uint32_t lfsr)
{
    uint32_t bit;

    uint32_t start_state = lfsr;
    uint32_t compareNr = 0;

#if 0
    uint64_t period = 0;
#else
    uint32_t period = 0;
#endif

    do {

        bit = B(24) ^ B(23) ^ B(22) ^ B(20) ^ B(19) ^ B(18) ^ B(17) ^ B(16) ^
            B(15) ^ B(13) ^ B(12) ^ B(8) ^ B(7) ^ B(6) ^ B(0);

        lfsr = (lfsr >> 1) | (bit << 31);

        ++period;

        if (period == 0) {
            printf("WRAP\n");
            break;
        }
    } while (lfsr != start_state);

    printf("%8.8X/%u\n", period, period);
}

int
main(void)
{

    lfsr_fib(1u << 31 | 1);

    return 0;
}