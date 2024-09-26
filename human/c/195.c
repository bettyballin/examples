#include <stdio.h>

int func(int x) {
    x = x & 15;
    x = -x;
    x = x >> 31;
    return x;
}

int main() {
    printf("%d\n", func(10));
    return 0;
}