#include <stdio.h>
#include <stdint.h>
#include <string.h>

int main() {
    uint32_t addr = 0xffd1cbb7;
    uint32_t values[6] = {0xc8, 0xf7f96540, 0x565a021a, 0, 0, 0xbfc3bfc3};

    printf("%s ", (char*)&addr);
    for (int i = 0; i < 6; i++) {
        printf("%x ", values[i]);
    }
    printf("\n");

    return 0;
}