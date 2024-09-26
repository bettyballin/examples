#include <stdio.h>
#include <stdlib.h>

void vulnerable(char *str) {
    printf(str);
}

int main(int argc, char **argv) {
    if (argc < 2) {
        printf("Usage: %s <string>\n", argv[0]);
        return 1;
    }
    vulnerable(argv[1]);
    return 0;
}