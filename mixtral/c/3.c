#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <flag>\n", argv[0]);
        return 1;
    }

    const char *valid_flags = "lRha";
    size_t len = strlen(argv[1]);
    char buffer[256];

    if (len > 0 && strchr(valid_flags, argv[1][0]) != NULL) {
        snprintf(buffer, sizeof(buffer) - 1, "ls -%s", argv[1]);
        system(buffer);
    } else {
        fprintf(stderr, "Invalid flag: %s\n", argv[1]);
        return 1;
    }

    return 0;
}