#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <time.h>

// Function to generate cryptographically secure pseudo-random numbers
void CSPRNG(uint8_t *buffer, size_t size) {
    FILE *fp = fopen("/dev/urandom", "r");
    fread(buffer, 1, size, fp);
    fclose(fp);
}

int main() {
    // Define two 52-byte messages
    uint8_t c1[52] = "This is a secret message.";

    // Generate a random padding of size 52 bytes
    uint8_t pad[52];
    CSPRNG(pad, sizeof(pad));

    // XOR the two messages with the random padding
    uint8_t result[104];
    memset(result, 0, sizeof(result));
    for (int i = 0; i < 52; i++) {
        result[i] = c1[i] ^ pad[i];
    }

    // Print the resulting ciphertext
    printf("Result: ");
    for (int i = 0; i < 52; i++) {
        printf("%02x", result[i]);
    }
    printf("\n");

    return 0;
}