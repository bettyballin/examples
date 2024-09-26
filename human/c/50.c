#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Error: password required\n");
        exit(1);
    }

    if (strlen(argv[1]) > 10) {
        printf("Error: password too long\n");
        exit(1);
    }

    return 0;
}