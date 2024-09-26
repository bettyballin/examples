
#include <stdio.h>

int main() {
    int encryptedCode;
    int num1, num2, num3, num4;
    int decryptedNum1, decryptedNum2, decryptedNum3, decryptedNum4;

    printf("\nEnter the 4-digit code to decrypt: ");
    scanf("%d", &encryptedCode);

    if (encryptedCode < 1000 || encryptedCode > 9999) {
        printf("The code must be a 4-digit number.\n");
        return 1;
    }

    // Decompose the encrypted number into
