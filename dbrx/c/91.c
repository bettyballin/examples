#include <openssl/aes.h>
#include <openssl/rand.h>
#include <stdio.h>
#include <stdlib.h>

int aes_encrypt(unsigned char *plaintext, int plaintext_len, unsigned char *key, unsigned char *iv, unsigned char *ciphertext) {
    EVP_CIPHER_CTX *ctx;
    int len;

    /* Create and initialize the context */
    ctx = EVP_CIPHER_CTX_new();
    if (!EVP_EncryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, key, iv))
        return 0;

    /* Encrypt plaintext */
    if (plaintext_len > INT_MAX - AES_BLOCK_SIZE)
        abort();
    if (!EVP_EncryptUpdate(ctx, ciphertext, &len, plaintext, plaintext_len))
        return 0;
    int ciphertext_len = len;

    /* Finalize encryption */
    if (!EVP_EncryptFinal_ex(ctx, ciphertext + len, &len))
        return 0;
    ciphertext_len += len;

    EVP_CIPHER_CTX_free(ctx);

    return ciphertext_len;
}

int aes_decrypt(unsigned char *ciphertext, int ciphertext_len, unsigned char *key, unsigned char *iv, unsigned char *plaintext) {
    EVP_CIPHER_CTX *ctx;
    int len;

    /* Create and initialize the context */
    ctx = EVP_CIPHER_CTX_new();
    if (!EVP_DecryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, key, iv))
        return 0;

    /* Decrypt ciphertext */
    if (ciphertext_len > INT_MAX - AES_BLOCK_SIZE)
        abort();
    if (!EVP_DecryptUpdate(ctx, plaintext, &len, ciphertext, ciphertext_len))
        return 0;
    int plaintext_len = len;

    /* Finalize decryption */
    if (!EVP_DecryptFinal_ex(ctx, plaintext + len, &len))
        return 0;
    plaintext_len += len;

    EVP_CIPHER_CTX_free(ctx);

    return plaintext_len;
}

int main() {
    unsigned char key[32];
    unsigned char iv[16];
    unsigned char plaintext[] = "Hello, World!";
    unsigned char ciphertext[256];
    unsigned char decrypted[256];

    RAND_bytes(key, 32);
    RAND_bytes(iv, 16);

    int ciphertext_len = aes_encrypt(plaintext, strlen((char*)plaintext), key, iv, ciphertext);
    printf("Ciphertext length: %d\n", ciphertext_len);

    int decrypted_len = aes_decrypt(ciphertext, ciphertext_len, key, iv, decrypted);
    printf("Decrypted length: %d\n", decrypted_len);

    printf("Decrypted text: %s\n", decrypted);

    return 0;
}