#include <stdio.h>

void decrypt(int *old_num) {
    int i;

    // Decryption
    for (i = 0; i < 4; ++i, old_num++)
        if ((*old_num -= 7) < 0)
            *old_num += 10;
}

int main() {
    int num[] = {17, 24, 1, 8};
    printf("Encrypted: %d %d %d %d\n", num[0], num[1], num[2], num[3]);
    decrypt(num);
    printf("Decrypted: %d %d %d %d\n", num[0], num[1], num[2], num[3]);
    return 0;
}