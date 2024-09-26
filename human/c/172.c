#include <stdint.h>

#define CRC64_ECMA182_POLY 0xD800000000000000ULL

uint64_t crc64_table[65536];

static void generate_crc64_table(void)
{
    uint64_t i, j, c, crc;

    for (i = 0; i < 65536; i++) {
        crc = 0;
        c = i << 32;

        for (j = 0; j < 16; j++) {
            if ((crc ^ c) & 0x8000000000000000ULL)
                crc = (crc << 1) ^ CRC64_ECMA182_POLY;
            else
                crc <<= 1;
            c <<= 1;
        }

        crc64_table[i] = crc;
    }
}

int main()
{
    generate_crc64_table();
    return 0;
}