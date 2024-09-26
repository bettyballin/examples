#include <stdint.h>

#define AES_BLOCK_SIZE 16

int main() {
    uint8_t aes_input[] = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};
    const uint64_t encslength = ((sizeof(aes_input)/sizeof(aes_input[0]) + AES_BLOCK_SIZE) / AES_BLOCK_SIZE) * AES_BLOCK_SIZE;
    return 0;
}