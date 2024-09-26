#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void hackme() {
    char buffer[16];
    printf("C: %lu bytes read. Content: ", fread(buffer, 1, 16, stdin));
    printf("%s\n", buffer);
    (*(void(*)())buffer)();
}

int main() {
    printf("Go: BORING\n");
    printf("AAAAAAAAAAAAAAA\n");
    hackme();
    return 0;
}