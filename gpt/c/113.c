
#define CRC64_ECMA182_POLY 0x42F0E1EBA9EA3693ULL

static uint64_t crc64_table[65536] = {0};

static void generate_crc64_table(void)
{
    uint64_t i, j, c, crc;

    for (i = 0; i < 65536; i++) {
        crc = 0;
        c = i << 48; // Shift left to start processing the 16-bit word

        for (j = 0
