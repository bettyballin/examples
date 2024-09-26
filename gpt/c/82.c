
#include <openssl/evp.h>
#include <string.h>
#include <stdio.h>

void print_hex(const char *label, const unsigned char *data, int len) {
    printf("%s:", label);
    for (int i = 0; i < len; i++) {
        printf(" %02X", data[i]);
    }
    printf("\n");
}

int calculate_cbc_mac(const unsigned char *data, size_t data_len, const unsigned char *key, const unsigned char *iv, unsigned char *mac, unsigned int *mac_len) {
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
