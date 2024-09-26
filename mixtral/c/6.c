#include <openssl/rand.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    unsigned char buffer[16];

    if (!RAND_bytes(buffer, sizeof(buffer))) {
        fprintf(stderr, "Error generating random bytes\n");
        exit(1);
    }

    // Use 'buffer' as your pseudo-random data
    for (int i = 0; i < sizeof(buffer); i++) {
        printf("%02x", buffer[i]);
    }
    printf("\n");

    return 0;
}