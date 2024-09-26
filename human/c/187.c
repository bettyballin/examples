#include <stdio.h>
#include <stdint.h>
#include <string.h>

int main() {
    uint32_t a = 0xffaf5307;
    uint32_t b = 0xc8;
    uint32_t c = 0xf7ed2540;
    uint32_t d = 0x565ad21a;
    uint32_t e = 0x0;
    uint32_t f = 0x41414141;

    printf("%x\n", a);
    printf("AAAA %x %x %x %x %x %x\n", b, c, d, e, f, a);

    return 0;
}