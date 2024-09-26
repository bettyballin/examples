
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>

int generate_random_number() {
    int fd;
    unsigned int random_number;

    fd = open("/dev/urandom", O_RDONLY); // Open the /dev/urandom device
    if (fd == -1) {
        perror("Error opening /dev/urandom");
        exit(EXIT_FAILURE);
    }

    // Read a random unsigned int from /dev/urandom
    if (read(fd, &random_number, sizeof(random_number)) != sizeof(random_number)) {
        perror("Error reading from /dev/urandom");
        exit(EXIT_FAILURE);
    }

    close(fd); // Close the device file

    return random_number;
}

int main() {
    int r = generate_random_number();
    printf("Random number: %u
