#include <stdio.h>

typedef struct {
    unsigned char k1[8];
    unsigned char k2[8];
    unsigned char k3[8];
} triple_des_key;

int main() {
    triple_des_key key;
    // Initialize key values for demonstration purposes
    for (int i = 0; i < 8; i++) {
        key.k1[i] = i;
        key.k2[i] = i + 8;
        key.k3[i] = i + 16;
    }

    // Example usage: print out the keys
    printf("Key 1: ");
    for (int i = 0; i < 8; i++) printf("%02x ", key.k1[i]);
    printf("\n");

    printf("Key 2: ");
    for (int i = 0; i < 8; i++) printf("%02x ", key.k2[i]);
    printf("\n");

    printf("Key 3: ");
    for (int i = 0; i < 8; i++) printf("%02x ", key.k3[i]);
    printf("\n");

    return 0;
}