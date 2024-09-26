#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char *str = malloc(10);

    strcpy(str, "Hello");

    printf("%s\n", str);

    free(str);

    // Fault: Using 'str' after it has been freed
    // printf("After Free: %c\n", *str); // Commented out to prevent undefined behavior

    return 0;
}