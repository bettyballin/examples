#include <stdio.h>

void swap_digit(int *num1, int *num2) {
    // Swapping
    int temp = *num1;

    *num1 = *num2;

    *num2 = temp;
}

int main() {
    int old_num[4] = {1, 2, 3, 4};

    printf("Before swapping: %d %d %d %d\n", old_num[0], old_num[1], old_num[2], old_num[3]);

    // Call this function after decryption
    swap_digit(&old_num[0], &old_num[2]);
    swap_digit(&old_num[1], &old_num[3]);

    printf("After swapping: %d %d %d %d\n", old_num[0], old_num[1], old_num[2], old_num[3]);

    return 0;
}