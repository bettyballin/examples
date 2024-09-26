#include <stdio.h>
#include <stdint.h>
#include <openssl/aes.h>

int main() {
    unsigned char data[] = "Hello, World!";
    int data_size = sizeof(data) - 1;
    unsigned char iv[AES_BLOCK_SIZE] = {0};
    AES_KEY aes_key;

    // Initialize AES key
    unsigned char key[] = "0123456789abcdef";
    AES_set_encrypt_key(key, 128, &aes_key);

    unsigned char encrypted_data[data_size + AES_BLOCK_SIZE];
    int num = AES_cbc_encrypt(data, encrypted_data, data_size, &aes_key, iv, AES_ENCRYPT);

    if (num < 0) {
        printf("Error: AES encryption failed\n");
        return 1;
    }

    printf("Encrypted data: ");
    for (int i = 0; i < num; i++) {
        printf("%02x", encrypted_data[i]);
    }
    printf("\n");

    return 0;
}