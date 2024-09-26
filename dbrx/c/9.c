#include <openssl/aes.h>
#include <openssl/err.h>
#include <stdio.h>
#include <string.h>

#define AES_BLOCK_SIZE 16

int main() {
    unsigned char aes_key[] = "0123456789012345"; // 128-bit key
    unsigned char iv[] = "0123456789012345"; // 128-bit IV
    unsigned char encrypted_data[] = "encrypted_data"; // encrypted data
    int encrypted_data_len = strlen((const char*)encrypted_data);
    int data_size = encrypted_data_len;

    unsigned char decrypted_data[data_size + AES_BLOCK_SIZE];
    int num = AES_cbc_encrypt(encrypted_data, encrypted_data_len, iv, aes_key, AES_ENCRYPT, decrypted_data);
    if (num < 0)
    {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    printf("Decrypted data: %s\n", decrypted_data);

    return 0;
}