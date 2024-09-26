#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/rand.h>

char* encrypt(const char *input_data, const unsigned char key[16], size_t input_len) {
    // Generate a random IV
    unsigned char iv[EVP_MAX_IV_LENGTH];
    RAND_bytes(iv, EVP_MAX_IV_LENGTH);

    // Create an AES context
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();

    // Initialize the context for encryption
    EVP_EncryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key, iv);

    // Allocate space for the encrypted data
    unsigned char *encrypted_data = malloc(input_len + EVP_MAX_BLOCK_LENGTH);
    size_t encrypted_len = 0;

    // Encrypt the input data
    EVP_EncryptUpdate(ctx, encrypted_data, &encrypted_len, (unsigned char *)input_data, input_len);

    // Finalize the encryption
    size_t final_len = 0;
    EVP_EncryptFinal_ex(ctx, encrypted_data + encrypted_len, &final_len);
    encrypted_len += final_len;

    // Clean up
    EVP_CIPHER_CTX_free(ctx);

    // Return the encrypted data as a string
    char *encrypted_str = malloc(encrypted_len + 1);
    memcpy(encrypted_str, encrypted_data, encrypted_len);
    encrypted_str[encrypted_len] = '\0';

    free(encrypted_data);

    return encrypted_str;
}