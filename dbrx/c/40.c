#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void rotate(char *str, size_t len, int rotn) {
    char temp[len];
    strcpy(temp, str);

    for (int i = 0; i < len; i++) {
        str[(i + rotn) % len] = temp[i];
    }
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <string> <rotation>\n", argv[0]);
        return 1;
    }

    int rotn = strtol(argv[2], NULL, 10);
    printf("String: %s\n", argv[1]);
    printf("Used Rotation degree: %d\n", rotn);

    size_t len = strlen(argv[1]); // get length of input string
    rotate(argv[1], len, rotn); // pass it to your function

    printf("Rotated string: %s\n", argv[1]);

    return 0;
}