
#include <stdio.h>
#include <stdlib.h>
#include "blake2s.h"

#define SIZE 1024

int main() {
    unsigned char str[SIZE];
    unsigned char hash[BLAKE2S_OUTBYTES]; // BLAKE2S_OUTBYTES is typically 32
    printf("> ");
    fgets(str, SIZE, stdin); // Safer than scanf

    // Calculate the hash
    if (blake2s
