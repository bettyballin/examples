// test.c
#include <stdio.h>
#include <openssl/sha.h>

int main() {
    unsigned char message[] = "Hello, World!";
    unsigned char hash[SHA256_DIGEST_LENGTH];

    SHA256(message, sizeof(message), hash);

    for (int i = 0; i < SHA256_DIGEST_LENGTH; i++) {
        printf("%02x", hash[i]);
    }
    printf("\n");

    return 0;
}