#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printHex(unsigned char *data, int length) {
    for (int i = 0; i < length; i++) {
        printf("%02x", data[i]);
    }
    printf("\n");
}

int encrypt(unsigned char *key, unsigned char *ciphertext) {
    // Your encryption logic here
    // For demonstration purposes, just copy the key to the ciphertext
    memcpy(ciphertext, key, 16);
    return 16;
}

void testKey(char *word) {
    unsigned char key[16];
    unsigned char ciphertext[16];
    int ciphertextLength;
    int successfulEncryption = 1;
    unsigned char *out = malloc(16);

    if (successfulEncryption){
        printf("Successful Encryption %02x\n", *out);

        ciphertextLength = encrypt(key, ciphertext);

        printHex(ciphertext, ciphertextLength);

        free(out);
    }
}

int main() {
    testKey("test");
    return 0;
}