#include <stdio.h>
#include <string.h>

int main() {
    long long c0 = 0x78661EB54FE76763;
    long long c1 = 0x98D9EC2327F1BF03;

    for (int i = 0; i <= 255; i++) {
        for (int j = 0; j <= 255; j++) {
            // Convert decimal values back to hexadecimal
            char hex_c0[16];
            sprintf(hex_c0, "%02X", (unsigned char)c0);
            char hex_c1[16];
            sprintf(hex_c1, "%02X", (unsigned char)c1);

            // Perform your operations here using the converted hexadecimal strings
            printf("%s %s\n", hex_c0, hex_c1);

            // Increment counter variables for next iteration
            c1++;
        }

        // Reset second loop variable to zero after each outer loop iteration
        c0++;
        c1 = 0x98D9EC2327F1BF03;
    }

    return 0;
}