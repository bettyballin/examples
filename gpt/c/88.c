
#include <openssl/cmac.h>
#include <stdio.h>

void dispHex(const unsigned char *buffer, unsigned int size) {
    for (unsigned int i = 0; i < size; i++) {
        printf("%02X ", buffer[i]);
    }
    printf("\n");
}

int main() {
    size_t out_len;
    unsigned char res[16]; // CMAC output size for AES is 128 bits (16 bytes)

    unsigned char mac_key[16] = {
        0x00, 0x01, 0x02, 0x03, 0x04
