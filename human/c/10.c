#include <stdio.h>

int encryption(int a, int b) {
    int d = 0;
    while (b >= (1 << d)) d++;
    return d - 1;
}

int main() {
    int a = 0;
    int b = (1 << 3) - 1; // example value
    printf("%d\n", encryption(a, b));
    return 0;
}