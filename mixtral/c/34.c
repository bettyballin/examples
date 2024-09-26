#include <stdio.h>
#include <stdlib.h>

void xor_hex(char *msg1, char *msg2) {
    unsigned int i;

    // Loop through each pair of hexadecimal characters
    for (i = 0; msg1[i] && msg2[i]; i += 2) {
        // Convert the current character pairs to integers
        char byte1 = strtol(msg1 + i, NULL, 16);
        char byte2 = strtol(msg2 + i, NULL, 16);

        // Perform XOR operation and print result
        printf("%02x", (byte1 ^ byte2));
    }

    puts("");
}

int main() {
    const char *ciphertext1 = "837f...(your ciphertext 1)";
    const char *ciphertext2 = "7e6f...(your ciphertext 2)";

    xor_hex((char *)ciphertext1, (char *)ciphertext2);

    return 0;
}