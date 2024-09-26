#include <stdio.h>

int main() {
    char c1[52] = "Hello, World!";
    char c2[52] = "Goodbye, World!";
    char xor[52];

    for(size_t i=0; i<52; i++) {
        xor[i] = c1[i] ^ c2[i];
    }

    printf("%s\n", xor);

    return 0;
}