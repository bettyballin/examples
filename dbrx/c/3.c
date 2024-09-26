#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <openssl/rand.h>

int main() {
    unsigned char rand_seed[32];
    int fd = open("/dev/random", O_RDONLY);
    read(fd, rand_seed, sizeof(rand_seed));
    close(fd);

    RAND_add(rand_seed, sizeof(rand_seed), 1.0); // seed the CSPRNG

    unsigned char random_bytes[32];
    RAND_bytes(random_bytes, sizeof(random_bytes));

    // Print the generated random bytes
    for (int i = 0; i < sizeof(random_bytes); i++) {
        printf("%02x", random_bytes[i]);
    }
    printf("\n");

    return 0;
}