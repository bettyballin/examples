#include <openssl/aes.h>
#include <openssl/err.h>
#include <stdio.h>
#include <stdlib.h>

#define AES_BLOCK_SIZE 16

void handleErrors(void) {
    ERR_print_errors_fp(stderr);
    abort();
}

int decrypt_aes(unsigned char *ciphertext, int ciphertext_len, unsigned char *key, unsigned char *iv, unsigned char *plaintext) {
    EVP_CIPHER_CTX *ctx;
    int len = 0, plaintext_len = 0;

    /* Create and initialize the context */
    if (!(ctx = EVP_CIPHER_CTX_new())) {
        handleErrors();
    }

    if (!EVP_DecryptInit_ex(ctx, EVP_aes_256_cbc(), NULL, key, iv)) {
        handleErrors();
    }

    /*
     * Provide data to be decrypted one or more parts, each of arbitrary length.
     *
     * Here we decrypt all ciphertext at once
     */
    if (!EVP_DecryptUpdate(ctx, plaintext, &len, ciphertext, ciphertext_len)) {
        handleErrors();
    }
    plaintext_len = len;

    /*
     * Finalize the decryption. Further out data bytes may be written by EVP_DecryptFinal_ex().
     *
     * Here we decrypt all remaining padding at once
     */
    if (!EVP_DecryptFinal_ex(ctx, plaintext + len, &len)) {
        handleErrors();
    }
    plaintext_len += len;

    /* Clean up and return the decrypted text */
    EVP_CIPHER_CTX_free(ctx);

    // Remove pad bytes from plain text buffer
    int padding_length = (int)plaintext[plaintext_len - 1];
    if (padding_length >= 0 && padding_length < AES_BLOCK_SIZE) {
        plaintext_len -= padding_length;
    }

    return plaintext_len;
}

int main() {
    unsigned char key[32];
    unsigned char iv[16];
    unsigned char ciphertext[] = { /* initialize with ciphertext */ };
    unsigned char plaintext[sizeof(ciphertext)];
    int ciphertext_len = sizeof(ciphertext);

    // Initialize key and iv
    for (int i = 0; i < 32; i++) {
        key[i] = 0x00;
    }
    for (int i = 0; i < 16; i++) {
        iv[i] = 0x00;
    }

    int decrypted_len = decrypt_aes(ciphertext, ciphertext_len, key, iv, plaintext);

    printf("Decrypted text: ");
    for (int i = 0; i < decrypted_len; i++) {
        printf("%c", plaintext[i]);
    }
    printf("\n");

    return 0;
}