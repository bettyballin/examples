#include <stdio.h>

int secure_memcmp(const void *a, const void *b, size_t len) {
    unsigned char x = 0;

    for (size_t i = 0; i < len; ++i) {
        volatile unsigned char a_byte = ((unsigned char *)a)[i];
        volatile unsigned char b_byte = ((unsigned char *)b)[i];

#if defined(__GNUC__) || defined(_MSC_VER)
        __asm__("" ::: "memory"); // Memory barrier
#endif

        x |= a_byte ^ b_byte;
    }

    return (int)(x - 1);
}

int main() {
    char str1[] = "Hello";
    char str2[] = "Hello";
    char str3[] = "World";

    printf("Comparing '%s' and '%s': %d\n", str1, str2, secure_memcmp(str1, str2, 5));
    printf("Comparing '%s' and '%s': %d\n", str1, str3, secure_memcmp(str1, str3, 5));

    return 0;
}