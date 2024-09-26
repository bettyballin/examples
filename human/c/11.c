#include <stdio.h>

int main() {
    unsigned short original = 0b10101000 << 8 | 0b11101001;
    unsigned short not_original = ~original;

    printf("Original: %d\n", (short)original);
    printf("~Original: %d\n", (short)not_original);

    return 0;
}