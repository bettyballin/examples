#include <stdio.h>
#include <openssl/evp.h>

#define MAX_CIPHERTEXT_LEN 1024

int encrypt(char *key, unsigned char* outbuf) {
    EVP_CIPHER_CTX ctx;
    EVP_CIPHER_CTX_init(&ctx);

    // ...

    int total_len = outlen + tmpLen;

    EVP_CIPHER_CTX_cleanup(&ctx);

    return total_len;
}

int main() {
    unsigned char ciphertext[MAX_CIPHERTEXT_LEN];
    int ciphertextLength;

    char key[] = "your_key_here";
    ciphertextLength = encrypt(key, ciphertext);

    return 0;
}