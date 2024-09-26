#include <stdio.h>

int main() {
    unsigned char hash[32];

    // Initialize hash array with some values (change this as needed)
    for (int i = 0; i < 32; ++i)
        hash[i] = i;

    for(int i = 0; i < 32; ++i)
        printf("%02x", hash[i]);
    printf("\n");

    return 0;
}