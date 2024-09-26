#include <stdio.h>
#include <stdint.h>

int main() {
    uint64_t ciphertext_C0 = 0x78661EB54FE76763;
    uint64_t ciphertext_C1 = 0x98D9EC2327F1BF03;

    for (int i = 0; i <= 0xff; ++i) {
        for (int j = 0; j <= 0xff; ++j) {
            printf("Current combination: 0x%02x 0x%02x\n", i, j);
            // Your algorithm goes here...
        }
    }
    return 0;
}