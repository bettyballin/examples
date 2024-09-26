#include <openssl/aes.h>
#include <stdint.h>
#include <stdio.h>
#include <string.h>

#define BLOCK_SIZE 16

void handle_error(const char *err) {
    printf("%s\n", err);
    exit(1);
}

void cbc_mac(const uint8_t *key, const uint8_t *message, size_t message_len, uint8_t mac[BLOCK_SIZE]) {
    AES_KEY aes_key;
    uint8_t iv[BLOCK_SIZE] = {0};
    uint8_t block[BLOCK_SIZE];
    int i;

    // Initialize the key
    if (AES_set_encrypt_key(key, 128, &aes_key) < 0)
        handle_error("Unable to set encryption key");

    // Process each message block
    for (i = 1; i <= message_len / BLOCK_SIZE; ++i) {
        memcpy(block, message + (i - 1) * BLOCK_SIZE, BLOCK_SIZE);
        AES_cbc_encrypt(block, mac, BLOCK_SIZE, &aes_key, iv, AES_ENCRYPT);
        memcpy(iv, mac, BLOCK_SIZE);
    }

    // Process the final block
    if ((message_len % BLOCK_SIZE) != 0) {
        memset(block, 0, BLOCK_SIZE);
        memcpy(block, message + (i - 1) * BLOCK_SIZE, message_len % BLOCK_SIZE);
        AES_cbc_encrypt(block, mac, BLOCK_SIZE, &aes_key, iv, AES_ENCRYPT);
    }
}

int main() {
    uint8_t key[BLOCK_SIZE] = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16};
    uint8_t message[] = "Hello, World!";
    uint8_t mac[BLOCK_SIZE];

    cbc_mac(key, message, strlen((char*)message), mac);

    printf("MAC: ");
    for (int i = 0; i < BLOCK_SIZE; ++i)
        printf("%02x", mac[i]);
    printf("\n");

    return 0;
}