#include <stdio.h>
#include "blowfish.h"

int main() {
    // Initialize variables
    int fileSize = 1024;  // replace with actual file size
    int j = 8;  // replace with actual block size
    unsigned char input[fileSize];
    BLOWFISH_CTX ctx;

    // Initialize Blowfish context
    Blowfish_Init(&ctx, (unsigned char *)"secret key", 11);

    // Encrypt data
    for (int i = 0; i < fileSize; i += j) {
        Blowfish_Encrypt(&ctx, input + i, input + i + j);
    }

    return 0;
}