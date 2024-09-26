#include <stdio.h>

void bcopy(unsigned char *from, unsigned char *to, int count) {
    #ifdef vax
        asm("movc3 12(ap),*4(ap),*8(ap)");
    #elif defined(u3b)
        asm("movblkb %r6, %r8, %r7");
    #else
        while ((count--) > 0)
            *to++ = *from++;
    #endif
}

int main() {
    unsigned char src[] = "Hello, World!";
    unsigned char dest[20];
    bcopy(src, dest, 13);
    printf("%s\n", dest);
    return 0;
}