Here is the modified C code:


#include <stdio.h>
#include <stdint.h>
#include <string.h>

void Encrypt(uint8_t* plainText, size_t len, uint8_t* key) {
    uint8_t keyA = 0;
    for (size_t i = 0; i < 20; i++) {
        keyA ^= key[i];
    }
    keyA &= 0xFF;

    uint8_t* codedText = (uint8_t*)malloc(len * sizeof(uint8_t));
    uint8_t* keyPtr = key;
    for (size_t i = 0; i < len; i++) {
        uint8_t xorVal = (keyPtr[i % 20] * keyA) & 0xFF;
        codedText[i] = (plainText[i] ^ xorVal) & 0xFF;
        keyA += codedText[i];
        keyA &= 0xFF;
    }

    for (size_t i = 0; i < len; i++) {
        printf("%c", codedText[i]);
    }
    free(codedText);
}

int main() {
    uint8_t plainText[] = { /* your plain text here */ };
    size_t len = sizeof(plainText) / sizeof(plainText[0]);
    uint8_t key[] = { /* your key here */ };

    Encrypt(plainText, len, key);

    return 0;
}