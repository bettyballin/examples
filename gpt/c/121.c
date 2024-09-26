
#include <openssl/evp.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int string2hexString(char* input, unsigned char* output) {
    // Your implementation of string2hexString should be here
    // It should convert input string to a byte array in hex format
    // and store it in output.
}

void print_hex(unsigned char *data, size_t len) {
    for (size_t i = 0; i < len; i++) {
        printf("%02x", data[i]);
    }
    printf("\n");
}

int encrypt(unsigned char *key, unsigned char *iv, char *plaintext,
