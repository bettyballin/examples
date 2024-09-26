#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/err.h>

#define BUFSIZE 1024

int main() {
    unsigned char key[32] = "01234567890123456789012345678901";
    unsigned char iv[16] = "0123456789012345";
    char *text = "Hello, World!";
    int outlen;
    unsigned char inbuf[BUFSIZE];
    unsigned char outbuf[BUFSIZE];

    strcpy((char*)inbuf, text);

    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    EVP_EncryptInit_ex(ctx, EVP_aes_256_cfb8(), NULL, key, iv);

    for (size_t i = 0; i < strlen(text); ++i) {
        if (!EVP_EncryptUpdate(ctx, outbuf + i, &outlen, inbuf + i, 1)) {
            return 0;
        }
    }

    if (!EVP_EncryptFinal_ex(ctx, outbuf + strlen(text), &outlen)) {
        return 0;
    }

    EVP_CIPHER_CTX_free(ctx);

    printf("Encrypted: ");
    for (int i = 0; i < strlen(text) + outlen; i++) {
        printf("%02x", outbuf[i]);
    }
    printf("\n");

    return 1;
}