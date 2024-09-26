#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void secure_zero(void *s, size_t n)
{
    volatile char *p = s;

    while (n--) *p++ = 0;
}

int main() {
    char str[] = "Hello, World!";
    printf("Before: %s\n", str);
    secure_zero(str, strlen(str));
    printf("After: %s\n", str);
    return 0;
}