#include <stdio.h>
#include <stdint.h>
#include <string.h>

// AES encryption/decryption library
#include "aes.h"

int main() {
    // Pad the key with zero values
    uint8_t key[] = "test\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";

    uint8_t iv[] = "aaaaaaaaaaaaaaaa";
    uint8_t ciphertextHex[] = "3771e837685ff5d4173801900de6e14c";

    // Hex decode (e.g. https://stackoverflow.com/a/3409211/9014097)
    uint8_t ciphertext[sizeof(ciphertextHex) / 2], * pos = ciphertextHex;
    for (size_t count = 0; count < sizeof ciphertext / sizeof * ciphertext; count++) {
        sscanf((const char*)pos, "%2hhx", &ciphertext[count]);
        pos += 2;
    }

    // Decrypt
    struct AES_ctx ctx;
    AES_init_ctx_iv(&ctx, key, iv);
    AES_CBC_decrypt_buffer(&ctx, ciphertext, sizeof(ciphertext));

    // Remove the PKCS7 padding
    uint8_t ciphertextLength = sizeof(ciphertext);
    uint8_t numberOfPaddingBytes = ciphertext[ciphertextLength - 1];
    ciphertext[ciphertextLength - numberOfPaddingBytes] = 0;

    printf("%s", ciphertext);

    return 0;
}