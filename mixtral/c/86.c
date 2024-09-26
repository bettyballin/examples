#include <stdint.h>
#include <stdio.h>

#define TABLE_SIZE 65536
#define CRC64_ECMA182_POLY 0xD800000000000000ULL

static uint64_t crc64_table[TABLE_SIZE] = {0};

void generate_crc64_table(void)
{
    for (uint16_t i = 0; i < TABLE_SIZE; ++i)
        crc64_table[i] = calculateCRC((char*)&i, sizeof(i));
}

// Function to compute CRC-64
static uint64_t calculateCRC(const char* data, size_t length)
{
    // Initialize the current CRC value
    uint64_t crc = 0;

    for (size_t i = 0; i < length; ++i)
        updateCRC(&crc, *(data + i));

    return ~crc;
}

// Function to compute the CRC-64 of a single byte
static void updateCRC(uint64_t* crc, char data)
{
     *crc ^= (uint64_t)(data) << 56U;

    for (int j = 0; j < 8; ++j){
        if (*crc & ((uint64_t)1ULL<<(63)))
            *crc = (*crc << 1)^CRC64_ECMA182_POLY;
         else
             *crc <<= 1U;
    }
}

int main() {
    generate_crc64_table();
    uint64_t crc = calculateCRC("Hello, World!", 13);
    printf("CRC-64: 0x%016llx\n", crc);
    return 0;
}