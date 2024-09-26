#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/evp.h>

char* encrypt(char *key, char *s) {
    unsigned char iv[16] = {0};
    unsigned char outbuf[256];

    int outlen1, outlen2;

    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();

    EVP_CipherInit_ex(ctx, EVP_aes_128_cbc(), NULL, (const unsigned char*)key, iv, 1);

    if (EVP_EncryptUpdate(ctx, outbuf, &outlen1, (const unsigned char*)s, strlen(s)) == 1) {
        int totalLen = outlen1 + EVP_CIPHER_CTX_block_size(ctx);
        if (totalLen <= 256) {
            if (EVP_EncryptFinal_ex(ctx, outbuf + outlen1, &outlen2) == 1) {
                outbuf[totalLen] = '\0';
                EVP_CIPHER_CTX_free(ctx);
                return (char*)outbuf;
            }
        }
    }
    EVP_CIPHER_CTX_free(ctx);
    return NULL;
}

int main() {
    char key[] = "0123456789abcdef";
    char s[] = "Hello, World!";
    char* encrypted = encrypt(key, s);
    if (encrypted != NULL) {
        printf("Encrypted: %s\n", encrypted);
    } else {
        printf("Encryption failed.\n");
    }
    return 0;
}