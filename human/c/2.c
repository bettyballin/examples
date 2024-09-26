#include <stdio.h>

void copy_memory(char *src, char *dest) {
    __asm__ volatile (
        "lds   si, [%1]\n"
        "les   di, [%2]\n"
        "cld\n"
        "mov   cx, 100\n"
        "rep   movsb\n"
        :
        : "r" (src), "r" (dest)
        : "si", "di", "cx"
    );
}

int main() {
    char src[100] = "Hello, world!";
    char dest[100];
    copy_memory(src, dest);
    printf("%s\n", dest);
    return 0;
}