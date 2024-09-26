
#include <stdio.h>

int check_parity(unsigned char *key, int key_length) {
    for (int i = 0; i < key_length; i++) {
        unsigned char k = key[i];
        k ^= k >> 4; // Compare the two halves
        k ^= k >> 2; // Compare the quarters
        k ^= k >> 1; // Compare the bits

        // If the parity bit is not set, return 0
        if (!((k & 1) == 1)) {
            return 0; // Parity bit does not match
        }
    }
    return 1; // All parity bits are correct
