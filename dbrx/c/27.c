#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    unsigned int r;

    fp = fopen("/dev/urandom", "r");
    if (fp == NULL) {
        printf("Error opening /dev/urandom\n");
        return 1;
    }

    fread(&r, sizeof(r), 1, fp);
    fclose(fp);

    printf("Random number: %u\n", r);

    return 0;
}