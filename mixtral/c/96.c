#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *str = malloc(10);

    strcpy(str, "Hello");

    printf("%s\n", str);

    free(str);

    return 0;
}