#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <openssl/evp.h>

// Function to add PKCS#7 padding
void PKCS7_Padding(uint8_t *plaintext, size_t plaintext_len, uint8_t **plaintext_padded, size_t *padded_len) {
    *padded_len = plaintext_len + (EVP_MAX_BLOCK_LENGTH - (plaintext_len % EVP_MAX_BLOCK_LENGTH));
    *plaintext_padded = malloc(*padded_len);
    memcpy(*plaintext_padded, plaintext, plaintext_len);
    for (size_t i = plaintext_len; i < *padded_len; i++) {
        (*plaintext_padded)[i] = (uint8_t)(*padded_len - plaintext_len);
    }
}

int main() {
    EVP_CIPHER_CTX *ctx;
    unsigned char ciphertext[128];
    int ciphertext_len;

    char *plaintext = "Hello, World!";
    size_t plaintext_len = strlen(plaintext);
    uint8_t *plaintext_padded;
    size_t padded_len;

    // Initialize the EVP context
    ctx = EVP_CIPHER_CTX_new();

    // Initialize the encryption operation
    EVP_EncryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, NULL, NULL);

    // Add PKCS#7 padding
    PKCS7_Padding((uint8_t *)plaintext, plaintext_len, &plaintext_padded, &padded_len);

    // Encrypt the padded plaintext
    EVP_EncryptUpdate(ctx, ciphertext, &ciphertext_len, plaintext_padded, padded_len);

    // Finalize the encryption operation
    EVP_EncryptFinal_ex(ctx, ciphertext + ciphertext_len, &ciphertext_len);

    // Clean up
    EVP_CIPHER_CTX_free(ctx);
    free(plaintext_padded);

    return 0;
}