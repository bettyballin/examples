#include <openssl/err.h>
#include <openssl/rand.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>

int main()
{
    // Read 16 bytes from /dev/random
    uint8_t entropy[16];
    int fd = open("/dev/random", O_RDONLY);
    if (fd < 0) {
        perror("open");
        return 1;
    }
    int ret = read(fd, entropy, 16);
    close(fd);
    if (ret != 16) {
        ERR_error_string(ERR_get_error(), "read");
        return 1;
    }

    // Seed Fortuna with the entropy
    RAND_seed(entropy, 16);

    // Generate random integers as needed
    int num = RAND_rand();
    printf("%d\n", num);

    return 0;
}