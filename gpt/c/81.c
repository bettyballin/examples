
#include <stdio.h>
#include <nettle/twofish.h>
#include <nettle/cbc.h>

int main() {
    const uint8_t key[TWOFISH_KEY_SIZE] = {
        // ... (as in your original snippet)
    };
    const uint8_t src[TWOFISH_BLOCK_SIZE] = {
        // ... (as in your original snippet)
    };
    const uint8_t iv[TWOFISH_BLOCK_SIZE] = {
        // ... (as in your original snippet)
    };
    uint8_t encrypted[T
