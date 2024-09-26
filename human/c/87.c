#include <stdio.h>

int main() {
    uint a = 5, b = 10;
    uint mask = -(uint)(a < b);
    a = ((a + b) & mask) | (a & ~mask);
    printf("%u\n", a);
    return 0;
}